package com.learn.demo.Utils;

import com.learn.demo.Grobal.GrobalConfig;

import java.util.UUID;

/**
 * @author demo
 * @date 2019/9/19 9:11
 * @description 单点登录工具类
 */
public class CasUtils {
    //region ticket
    public String createTicket(){
        return GrobalConfig.TICKET_TITLE+ UUID.randomUUID();
    }

    public boolean verifyTicket(){
        return false;
    }
    //endregion

    //region ticket redis
    private void redisAddClient(){

    }
    //endregion
}
