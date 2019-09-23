package com.learn.demo.model;

import com.learn.demo.enums.ResultEnum;
import lombok.Getter;
import lombok.Setter;

/*
 * 自定义异常
 */
public class MyExceptionModel extends RuntimeException {

  @Getter
  @Setter
  private Integer code;

  public MyExceptionModel(String msg) {
    super(msg);
    this.code = ResultEnum.ERROR.getCode();
  }

  public MyExceptionModel(int code, String msg) {
    super(msg);
    this.code = code;
  }

  public MyExceptionModel(ResultEnum result) {
    super(result.getMsg());
    this.code = result.getCode();
  }
}
