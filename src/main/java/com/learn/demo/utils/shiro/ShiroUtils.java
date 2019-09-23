package com.learn.demo.utils.shiro;

import com.learn.demo.entity.UserEntity;
import com.learn.demo.global.GlobalConfig;
import com.learn.demo.model.MyExceptionModel;
import com.learn.demo.model.RedisUserModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;

/**
 * Shiro工具类.
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/9/23 16:34
 */
@Slf4j
@Component
public class ShiroUtils {

  /**
   * shiro保存用户信息.
   *
   * @param user 用户信息
   */
  public void login(UserEntity user) {
    UsernamePasswordToken token = new UsernamePasswordToken(user.getAccount(), user.getPassword());
    Subject subject = SecurityUtils.getSubject();
    try {
      subject.login(token);  //这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中
    } catch (Exception ex) {
      throw new MyExceptionModel(ex.getMessage());
    }
    if (subject.isAuthenticated()) {              //验证是否登录成功
      Session session = Jurisdiction.getSession();
      session.removeAttribute(GlobalConfig.ShiroAccount);
      session.removeAttribute(GlobalConfig.ShiroUser);
      session.setAttribute(GlobalConfig.ShiroUser, user);
      session.setAttribute(GlobalConfig.ShiroAccount, user.getAccount());
    } else {
      token.clear();
      throw new MyExceptionModel("尝试登录系统失败,无权限");
    }
  }
}
