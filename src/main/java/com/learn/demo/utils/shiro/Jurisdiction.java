package com.learn.demo.utils.shiro;

import com.learn.demo.entity.UserEntity;
import com.learn.demo.utils.ConstUtils;
import com.learn.demo.utils.JsonUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Component;

/**
 * 权限工具类.
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/9/23 16:48
 */
@Component
public class Jurisdiction {

  /**
   * shiro管理的session.
   *
   * @return session
   */
  public static Session getSession() {
    return SecurityUtils.getSubject().getSession();
  }

  /**
   * 获取当前登录的用户名.
   *
   * @return 用户账号
   */
  public static String getAccount() {
    return getSession().getAttribute(ConstUtils.ShiroAccount).toString();
  }

  /**
   * 获取shiro用户对象.
   * @return 用户对象
   */
  public static UserEntity getUser() {
    return JsonUtils
        .toBean(getSession().getAttribute(ConstUtils.ShiroUser).toString(), UserEntity.class);
  }

}
