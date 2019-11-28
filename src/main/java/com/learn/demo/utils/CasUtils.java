package com.learn.demo.utils;

import com.learn.demo.entity.CasClientLogEntity;
import com.learn.demo.entity.ClientAppEntity;
import com.learn.demo.model.MyExceptionModel;
import com.learn.demo.model.RedisClientModel;
import com.learn.demo.model.RedisUserModel;
import com.learn.demo.model.SystemConfigModel;
import com.learn.demo.service.CasClientLogService;
import com.learn.demo.utils.redis.RedisTicketUtils;
import com.learn.demo.utils.redis.RedisUserUtils;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * 单点登录工具类.
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/9/19 9:11
 */
@Component
public class CasUtils {

  @Resource
  private RedisUserUtils redisUserUtils;

  @Resource
  private RedisTicketUtils redisTicketUtils;

  @Resource
  private DateUtils dateUtils;

  @Resource
  private CasClientLogService casClientLogService;

  @Resource
  private SystemConfigModel systemConfigModel;

  @Resource
  private EnumUtils enumUtils;

  //ticket

  /**
   * 创建票据.
   *
   * @return 票据
   */
  private String createTicket() {
    return ConstUtils.TICKET_HEAD + UUID.randomUUID();
  }

  /**
   * 验证票据.
   *
   * @param data 提交数据
   * @return 票据验证结果
   */
  public RedisUserModel verifyTicket(Map data) {
    String ticket = data.get("ST").toString();
    String service = data.get("service").toString();
    String code = data.get("code").toString();
    String clientSessionId = data.get("sessionId").toString();

    if ("".equals(ticket) || "".equals(service) || "".equals(code)) {
      throw new MyExceptionModel("验证票据参数不对");
    }

    String userId = redisTicketUtils.getUserId(ticket);

    if (userId == null) {
      throw new MyExceptionModel("无效票据！");
    }

    RedisUserModel user = redisUserUtils.getUserOfUserId(userId);

    if (user == null) {
      throw new MyExceptionModel("用户未登录！");
    }

    RedisClientModel clientModel = user.getClients().get(service);

    if (clientModel == null) {
      throw new MyExceptionModel("客户端未登录！");
    } else {
      redisTicketUtils.delete(ticket);
      if (clientModel.getTicketValidated().equals(-1)) {
        Map<String, RedisClientModel> clients = user.getClients();
        //移除旧的
        clients.remove(service);

        clientModel.setTicketValidated(1);
        clientModel.setTicketValidateTime(new Date());
        clientModel.setSessionIdValue(clientSessionId);

        String description = "";

        if (!clientModel.getAppLoginUrl().equals(service) || !clientModel.getCode().equals(code)) {
          clientModel.setTicketValidated(0);
          description = "客户端不一致！";
        }
        if (dateUtils
            .addSecond(clientModel.getTicketCreateTime(), clientModel.getTicketEffectiveTime())
            .after(new Date())
        ) {
          clientModel.setTicketValidated(0);
          description = "票据已过期！";
        }

        CasClientLogEntity log = casClientLogService
            .updateOfVerifyTicket(clientSessionId, clientModel, description);

        clientModel.setClientLogId(log.getAppLogId());

        clients.put(service, clientModel);
        user.setClients(clients);
        //添加编辑后的
        redisUserUtils.update(user);

        if (clientModel.getTicketValidated().equals(1)) {
          return user;
        } else {
          throw new MyExceptionModel(description);
        }
      } else {
        throw new MyExceptionModel("客户端已登录校验！");
      }
    }
  }
  //endregion

  //region ticket redis

  /**
   * 更新创建redis用户里的客户端信息.
   *
   * @param sessionId sessionId
   * @param client    数据库客户端信息
   * @param data      前端数据
   * @return 票据
   */
  public String getTicket(String sessionId, ClientAppEntity client, Map data) {
    RedisUserModel redisUser = redisUserUtils.getUserOfSessionId(sessionId);
    if (redisUser == null) {
      throw new MyExceptionModel("redis 用户数据不存在");
    }
    Map<String, RedisClientModel> redisClientMap = redisUser.getClients();
    RedisClientModel redisClient = null;

    String code = data.get("code").toString();

    if (!redisClientMap.isEmpty()) {
      redisClient = redisClientMap.get(client.getAppId());
    }

    if (redisClient == null) {
      redisClient = new RedisClientModel();
      redisClient.setAppId(client.getAppId());
      redisClient.setAppLoginUrl(client.getAppLoginUrl());
      redisClient.setAppName(client.getAppName());
      redisClient.setTicketEffectiveTime(systemConfigModel.getTicketEffectiveTimeOut());
      redisClient.setSessionIdKey(enumUtils.getSessionKey(client.getAppPlatform()));
    } else {
      redisClientMap.remove(client.getAppLoginUrl());//移除旧的
    }
    String ticket = createTicket();
    redisClient.setCode(code);
    redisClient.setTicket(ticket);
    redisClient.setTicketCreateTime(new Date());
    redisClient.setTicketValidated(-1);
    redisClientMap.put(client.getAppLoginUrl(), redisClient);
    redisUser.setClients(redisClientMap);

    casClientLogService.createOfTicket(redisClient);

    redisUserUtils.update(redisUser);
    redisTicketUtils.save(ticket, redisUser.getUserId());
    return ticket;
  }

}
