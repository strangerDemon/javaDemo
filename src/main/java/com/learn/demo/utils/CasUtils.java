package com.learn.demo.utils;

import com.learn.demo.global.GlobalConfig;
import java.util.UUID;
import org.springframework.stereotype.Component;

/**
 * 单点登录工具类.
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/9/19 9:11
 */
@Component
public class CasUtils {


  /**
   * 创建票据.
   *
   * @return 票据
   */
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


}
