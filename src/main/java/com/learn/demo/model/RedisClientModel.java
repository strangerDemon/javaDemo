package com.learn.demo.model;

import java.util.Date;
import lombok.Data;

/*
 * @author demo
 * @date 2019/9/22 18:18
 * @description redis 缓存的客户端（接入系统）对象信息
 * @version 1.0.0
 */
@Data
public class RedisClientModel {

  //主键
  private String appId;

  //名称
  private String appName;

  //URL
  private String appLoginUrl;

  // 私有回话主键类型
  private String sessionIdKey;

  // 私有回话主键
  private String sessionIdValue;

  // 防伪标识
  private String code;

  // 票据
  private String ticket;

  // 票据颁发时间
  private Date ticketCreateTime;

  // 票据有效时间 以秒为单位，默认为10秒
  private Integer ticketEffectiveTime;

  /**
   * 票据是否验证. -1 未验证 0失败 1成功
   */
  private Integer ticketValidated;

  // 票据验证时间
  private Date ticketValidateTime;

  // 客户端日志id
  private String clientLogId;
}
