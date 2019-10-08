package com.learn.demo.utils.redis;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * ticket redis.
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/10/8 17:48
 */
@Component
public class RedisTicketUtils {

  @Resource
  private RedisUtils redisUtils;

  public void save(String ticket, String userId) {
    redisUtils.set(ticket, userId);
  }

  public void delete(String ticket) {
    redisUtils.delete(ticket);
  }
}
