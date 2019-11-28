package com.learn.demo.enums;

import lombok.Getter;
import lombok.Setter;

/**
 * 返回枚举，统一维护返回类型.
 *
 * @author demo
 * @version 1.0.0
 * @date
 */
public enum ResultEnum {
  /**
   * 接口返回类型.
   */
  UNKNOWN(-1, "未知"),
  ERROR(0, "失败"),
  SUCCESS(1, "成功");

  @Getter
  @Setter
  private Integer code;

  @Getter
  @Setter
  private String msg;

  ResultEnum(Integer code, String msg) {
    this.code = code;
    this.msg = msg;
  }

}
