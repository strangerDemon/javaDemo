package com.learn.demo.utils.redis;

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
   * 清除redis用户登录信息.
   */
  public void delete(String sessionId) {
    String userId = redisUtils.get(sessionId);
    redisUtils.delete(sessionId);
    redisUtils.delete(userId);
  }


  /**
   * 获取redis用户.
   */
  public RedisUserModel getUser(String sessionId) {
    String userId = redisUtils.get(sessionId);
    if (userId == null || userId.equals("")) {
      return null;
    }
    String userJson = redisUtils.get(userId);
    if (userJson == null || userJson.equals("")) {
      return null;
    }
    return JsonUtils.toBean(userJson, RedisUserModel.class);
  }

  /**
   * redis 保存用户 sessionId=>userId=>user 解决多地登录.
   */
  public void save(String sessionId, RedisUserModel redisUser) {
    redisUtils.set(sessionId, redisUser.getUserId());
    redisUtils.set(redisUser.getUserId(), JsonUtils.toJson(redisUser));
  }

  /**
   * 更新用户.
   */
  public void update(String userId, RedisUserModel redisUser) {
    redisUtils.set(redisUser.getUserId(), JsonUtils.toJson(redisUser));
  }
}
