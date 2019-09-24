package com.learn.demo.aop;

import com.learn.demo.model.ResultModel;
import com.learn.demo.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * controller的接口异常处理. ControllerAdvice：类上声明的注解. 结合方法型注解@ExceptionHandler，用于捕获Controller中抛出的指定类型的异常，从而达到不同类型的异常区别处理的目的.
 * 结合方法型注解@InitBinder，用于request中自定义参数解析方式进行注册，从而达到自定义指定格式参数的目的. 结合方法型注解@ModelAttribute，表示其标注的方法将会在目标Controller方法执行之前执行。
 *
 * @author demo
 * @version 1.0.0
 * @date
 */
@Slf4j
@ControllerAdvice
public class ExceptionHandle {

  @ExceptionHandler(value = Exception.class)
  @ResponseBody
  public ResultModel handle(Exception ex) {
    log.error("handle exception:{}", ex.toString());
    return ResultUtils.isError(ex.getMessage());
  }


}
