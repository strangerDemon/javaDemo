package com.learn.demo.Model;

import com.learn.demo.Enum.ResultEnum;

public class ResultModel {
    private Integer status;
    private String msg;
    private Object data;

    public ResultModel(ResultEnum result, Object data) {
        this.status = result.getCode();
        this.msg = result.getMsg();
        this.data = data;
    }

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

    @Override
    public String toString() {
        return "ResultModel{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
