package com.learn.demo.utils;

import com.learn.demo.entity.CasClientLogEntity;
import com.learn.demo.entity.ClientAppEntity;
import com.learn.demo.model.MyExceptionModel;
import com.learn.demo.model.RedisClientModel;
import com.learn.demo.model.RedisUserModel;
import com.learn.demo.service.CasClientLogService;
import com.learn.demo.utils.redis.RedisUserUtils;
import com.learn.demo.utils.redis.RedisUtils;
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
  private RedisUtils redisUtils;

  @Resource
  private RedisUserUtils redisUserUtils;

  @Resource
  private CasClientLogService casClientLogService;
  //ticket

  /**
   * 创建票据.
   *
   * @return 票据
   */
  private String createTicket() {
    return ConstUtils.TicketHead + UUID.randomUUID();
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
    String sessionIdKey = data.get("sessionIdKey").toString();
    String sessionIdValue = data.get("sessionIdValue").toString();

    if (ticket.equals("") || service.equals("") || code.equals("")) {
      throw new MyExceptionModel("验证票据参数不对");
    }

    String userId = redisUtils.get(ticket);

    if (userId == null) {
      throw new MyExceptionModel("无效票据！");
    }

    String sessionId = redisUtils.get(userId);

    if (sessionId == null) {
      throw new MyExceptionModel("用户未登录！");
    }

    RedisUserModel user = JsonUtils.toBean(redisUtils.get(sessionId), RedisUserModel.class);

    if (user == null) {
      throw new MyExceptionModel("用户未登录！");
    }

    if (user.getClients().isEmpty()) {
      throw new MyExceptionModel("用户未登录客户端！");
    }

    RedisClientModel clientModel = user.getClients().get(service);

    if (clientModel == null) {
      throw new MyExceptionModel("客户端未登录！");
    } else {
      redisUtils.delete(ticket);
      if (clientModel.getTicketValidated().equals(-1)) {
        Map<String, RedisClientModel> clients = user.getClients();
        clients.remove(service);//移除旧的

        clientModel.setTicketValidated(1);
        clientModel.setTicketValidateTime(new Date());
        clientModel.setSessionIdKey(sessionIdKey);
        clientModel.setSessionIdValue(sessionIdValue);
        ;
        String description = "";

        if (!clientModel.getAppLoginUrl().equals(service) || !clientModel.getCode().equals(code)) {
          clientModel.setTicketValidated(0);
          description = "客户端不一致！";
        }

        CasClientLogEntity log = casClientLogService
            .updateOfVerifyTicket(sessionId, clientModel, description);

        clientModel.setClientLogId(log.getAppLogId());

        clients.put(service, clientModel);
        user.setClients(clients);

        redisUtils.set(sessionId, JsonUtils.toJson(user));//添加编辑后的

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
  public String addOrUpdateRedisClient(String sessionId, ClientAppEntity client, Map data) {
    RedisUserModel redisUser = redisUserUtils.getUser(sessionId);
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
    } else {
      redisClientMap.remove(client.getAppId());//移除旧的
    }
    String ticket = createTicket();
    redisClient.setCode(code);
    redisClient.setTicket(ticket);
    redisClient.setTicketCreateTime(new Date());
    redisClient.setTicketValidated(-1);
    redisClientMap.put(client.getAppId(), redisClient);
    redisUser.setClients(redisClientMap);

    casClientLogService.createOfTicket(sessionId, redisClient);

    redisUserUtils.update(redisUser.getUserId(), redisUser);
    return ticket;
  }

}
