package com.learn.demo.utils.redis;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * ticket redis. ticket=>userId.
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/10/8 17:48
 */
@Component
public class RedisTicketUtils {

  @Resource
  private RedisUtils redisUtils;

  /**
   * 保存ticket=>userId 对应关系.
   */
  public void save(String ticket, String userId) {
    redisUtils.set(ticket, userId);
  }

  /**
   * 删除票据.
   */
  public void delete(String ticket) {
    redisUtils.delete(ticket);
  }

  /**
   * 获取用户用户id ticket=>userId.
   */
  public String getUserId(String ticket) {
    String userId = redisUtils.get(ticket);
    if (userId == null || userId.equals("")) {
      return null;
    }
    return userId;
  }
}
