package com.learn.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.Map;
import lombok.Data;

/**
 * cas登录redis缓存的用户信息.
 * @author demo
 * @version 1.0.0
 * @date 2019/9/22 18:05
 */
@Data
public class RedisUserModel {

  // 用户主键
  private String userId;

  // 用户姓名
  private String userName;

  // 登陆账户
  private String account;

  // 密码
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String password;

  // 登录时间
  private Date logTime;

  // cas 日志
  private String casLogId;

  private Map<String,RedisClientModel> clients;
}
