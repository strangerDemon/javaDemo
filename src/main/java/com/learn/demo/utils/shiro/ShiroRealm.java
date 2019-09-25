package com.learn.demo.utils.shiro;

import com.learn.demo.entity.UserEntity;
import com.learn.demo.service.UserService;
import com.learn.demo.utils.JsonUtils;
import com.learn.demo.utils.RedisUtils;
import java.util.Collection;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * shiro 权限校验.
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/9/19 10:19
 */
@Slf4j
@Component
public class ShiroRealm extends AuthorizingRealm {

  @Resource
  @Lazy
  private UserService userService;

  @Resource
  @Lazy
  private RedisUtils redisUtils;

  @Resource
  @Lazy
  private HttpSession session;

  /**
   * 登录认证.每次接口访问时，校验用户是否登录
   *
   * @param authenticationToken token
   * @return 用户信息
   * @throws AuthenticationException 异常
   */
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
      throws AuthenticationException {
    //UsernamePasswordToken用于存放提交的登录信息
    UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
    try {
      UserEntity user = userService.getByAccount(token.getUsername());
      if (user != null) {
        return new SimpleAuthenticationInfo(user.getAccount(), user.getPassword(), getName());
      }
    } catch (Exception e) {
      log.error("doGetAuthenticationInfo:{}", e.getMessage());
      return null;
    }
    return null;
  }

  /**
   * 权限认证: roles、permissions.
   *  =>@RequiresRoles("***") 角色权限.
   *  =>@RequiresPermissions("****") 账号的接口权限.
   *
   * @param principals principals 身份集合
   * @return AuthorizationInfo
   */
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    String userName = (String) super.getAvailablePrincipal(principals);
    SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
    Collection<String> shiroSet = JsonUtils.cast(session.getAttribute(userName));
    if (null != shiroSet) {
      info.addStringPermissions(shiroSet);
      return info;
    } else {
      log.info("doGetAuthorizationInfo:{}", userName + "未查询到用户信息");
      return null;
    }
  }

}
