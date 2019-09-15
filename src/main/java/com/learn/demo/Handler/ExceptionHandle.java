package com.learn.demo.Handler;

import com.learn.demo.Model.ResultModel;
import com.learn.demo.Utils.ResultUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultModel handle(Exception ex) {
        return ResultUtils.isError(ex.getMessage());
    }
}
