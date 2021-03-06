package com.learn.demo.model;

import com.learn.demo.enums.ResultEnum;
import lombok.Data;

/**
 * 接口返回对象.
 *
 * @author demo
 * @version 1.0.0
 * @date
 */
@Data
public class ResultModel {

  //状态码
  private Integer status;
  //文字信息
  private String msg;
  //数据
  private Object data;
  //时间戳
  private long timestamp = System.currentTimeMillis();
  /**
   * 根据枚举对象创建返回对象.
   *
   * @param result 返回枚举对象
   * @param data   数据
   */
  public ResultModel(ResultEnum result, Object data) {
    this.status = result.getCode();
    this.msg = result.getMsg();
    this.data = data;
  }

  /**
   * 自定义返回对象.
   *
   * @param status 返回码
   * @param msg    返回消息
   * @param data   数据
   */
  public ResultModel(Integer status, String msg, Object data) {
    this.status = status;
    this.msg = msg;
    this.data = data;
  }
}
