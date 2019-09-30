package com.learn.demo.utils;

import com.learn.demo.entity.ClientAppEntity;
import com.learn.demo.model.RedisClientModel;
import com.learn.demo.model.RedisUserModel;
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
  //ticket

  /**
   * 创建票据.
   *
   * @return 票据
   */
  private String createTicket() {
    return ConstUtils.TicketHead + UUID.randomUUID();
  }

  public boolean verifyTicket() {
    return false;
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
    RedisUserModel redisUser = JsonUtils.toBean(redisUtils.get(sessionId), RedisUserModel.class);
    assert redisUser != null;
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

    return ticket;
  }

}
