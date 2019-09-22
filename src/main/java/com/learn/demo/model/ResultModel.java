package com.learn.demo.model;

import com.learn.demo.enums.ResultEnum;

public class ResultModel {

  private Integer status;
  private String msg;
  private Object data;

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
   * @param status 返回码
   * @param msg 返回消息
   * @param data 数据
   */
  public ResultModel(Integer status, String msg, Object data) {
    this.status = status;
    this.msg = msg;
    this.data = data;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

}