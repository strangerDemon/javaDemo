package com.learn.demo.utils;

import com.learn.demo.enums.ResultEnum;
import com.learn.demo.model.ResultModel;
import org.springframework.stereotype.Component;

@Component
public class ResultUtils {

  public static ResultModel isOK() {
    return new ResultModel(ResultEnum.SUCCESS, null);
  }

  public static ResultModel isOK(Object data) {
    return new ResultModel(ResultEnum.SUCCESS, data);
  }

  public static ResultModel isError() {
    return new ResultModel(ResultEnum.ERROR, null);
  }

  /**
   * 错误.
   *
   * @param msg 错误信息
   * @return 返回对象
   */
  public static ResultModel isError(String msg) {
    ResultModel result = new ResultModel(ResultEnum.ERROR, null);
    result.setMsg(msg);
    return result;
  }

  public static ResultModel isUnKnow() {
    return new ResultModel(ResultEnum.UNKNOWN, null);
  }

}
