package com.learn.demo.Enum;

/**
 * 返回枚举，统一维护返回类型
 */
public enum ResultEnum {
    UNKNOW(-1,"未知"),
    ERROR(0,"失败"),
    SUCCESS(1,"成功");

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
