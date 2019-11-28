package com.learn.demo.enums;

import lombok.Getter;
import lombok.Setter;

/**
 * 平台枚举.
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/10/9 14:58
 */
public enum PlatformEnum {
  /**
   * NET JAVA PHP Default sessionId.
   */
  NET(".net", "ASP.NET_SessionId"),
  JAVA("java", "JSESSIONID"),
  PHP("php", "session_id"),
  Default("default", "JSESSIONID");

  @Getter
  @Setter
  private String platform;

  @Getter
  @Setter
  private String sessionKey;

  PlatformEnum(String platform, String sessionKey) {
    this.platform = platform;
    this.sessionKey = sessionKey;
  }

}
