package com.learn.demo.Model;

import com.learn.demo.Enum.ResultEnum;

/**
 * 自定义异常
 */
public class MyExceptionModel  extends RuntimeException{
    private Integer code;
    public MyExceptionModel(int code,String msg){
        super(msg);
        this.code=code;
    }

    public MyExceptionModel(ResultEnum result){
        super(result.getMsg());
        this.code=result.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
