package com.learn.demo.utils.redis;

import com.learn.demo.model.MyExceptionModel;
import com.learn.demo.model.RedisUserModel;
import com.learn.demo.utils.JsonUtils;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * 用户redis.
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/10/8 17:32
 */
@Component
public class RedisUserUtils {

  @Resource
  private RedisUtils redisUtils;

  /**
   * 获取用户 userId=>sessionId=>user.
   */
  public RedisUserModel getUserOfUserId(String userId) {
    String sessionId = redisUtils.get(userId);
    if (sessionId == null || "".equals(sessionId)) {
      return null;
    }
    return getUserOfSessionId(sessionId);
  }

  /**
   * 获取用户 sessionId=>user.
   */
  public RedisUserModel getUserOfSessionId(String sessionId) {
    String userJson = redisUtils.get(sessionId);
    if (userJson == null || "".equals(userJson)) {
      return null;
    }
    return JsonUtils.toBean(userJson, RedisUserModel.class);

  }

  /**
   * redis 保存用户 userId=>sessionId=>user 解决多地登录.
   */
  public void save(String sessionId, RedisUserModel redisUser) {
    redisUtils.set(redisUser.getUserId(), sessionId);
    redisUtils.set(sessionId, JsonUtils.toJson(redisUser));
  }

  /**
   * 更新用户.
   */
  public void update(RedisUserModel redisUser) {
    String sessionId = redisUtils.get(redisUser.getUserId());
    if (sessionId == null || "".equals(sessionId)) {
      throw new MyExceptionModel("redis更新用户信息异常:找不到sessionId");
    }
    redisUtils.set(redisUser.getUserId(),sessionId);
    redisUtils.set(sessionId, JsonUtils.toJson(redisUser));
  }

  /**
   * 清除redis用户登录信息.
   */
  public void delete(String userId) {
    String sessionId = redisUtils.get(userId);
    redisUtils.delete(userId);
    redisUtils.delete(sessionId);
  }
}
