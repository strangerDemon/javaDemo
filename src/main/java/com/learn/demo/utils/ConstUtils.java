package com.learn.demo.utils;

import org.springframework.stereotype.Component;

/**
 * 全局常量类.
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/9/19 9:15
 */
@Component
public class ConstUtils {

  /**
   * 票据头.
   */
  public static final String TICKET_HEAD = "ST_";

  /**
   * shiro 用户对象信息.
   */
  public static final String SHIRO_USER = "Shiro_User";

  /**
   * shiro账号.
   */
  public static final String SHIRO_ACCOUNT = "Shiro_Account";
}
