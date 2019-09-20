package com.learn.demo.utils;

import com.learn.demo.global.GlobalConfig;
import java.util.UUID;

/*
 * @author demo
 * @date 2019/9/19 9:11
 * @description 单点登录工具类
 */
public class CasUtils {

  //region ticket
  public String createTicket() {
    return GlobalConfig.TicketHead + UUID.randomUUID();
  }

  public boolean verifyTicket() {
    return false;
  }
  //endregion

  //region ticket redis
  private void redisAddClient() {

  }
  //endregion
}
