package com.learn.demo.shiro;

import com.learn.demo.service.UserService;
import com.learn.demo.utils.RedisUtils;
import javax.annotation.Resource;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/*
 * @author demo
 * @date 2019/9/19 10:19
 * @description shiro 权限校验
 */
@Component
public class ShiroRealm extends AuthorizingRealm {

  private static final  Logger logger = LoggerFactory.getLogger(ShiroRealm.class);

  @Resource
  @Lazy
  private UserService sysUserService;
  @Resource
  @Lazy
  private RedisUtils redisUtils;

  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    return null;
  }

  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth)
      throws AuthenticationException {
    return null;
  }

}
