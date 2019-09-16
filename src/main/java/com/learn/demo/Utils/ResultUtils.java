package com.learn.demo.Utils;

import com.learn.demo.Enum.ResultEnum;
import com.learn.demo.Model.ResultModel;

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

    public static ResultModel isError(String msg) {
        ResultModel result= new ResultModel(ResultEnum.ERROR, null);
        result.setMsg(msg);
        return result;
    }

}
