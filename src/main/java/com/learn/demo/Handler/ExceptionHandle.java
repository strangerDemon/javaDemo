package com.learn.demo.Handler;

import com.learn.demo.Model.ResultModel;
import com.learn.demo.Utils.ResultUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 结合方法型注解@ExceptionHandler，用于捕获Controller中抛出的指定类型的异常，从而达到不同类型的异常区别处理的目的；
 * 结合方法型注解@InitBinder，用于request中自定义参数解析方式进行注册，从而达到自定义指定格式参数的目的；
 * 结合方法型注解@ModelAttribute，表示其标注的方法将会在目标Controller方法执行之前执行。
 * @description ControllerAdvice：类上声明的注解
 * @description controller的接口异常处理
 */
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultModel handle(Exception ex) {
        return ResultUtils.isError(ex.getMessage());
    }



}
