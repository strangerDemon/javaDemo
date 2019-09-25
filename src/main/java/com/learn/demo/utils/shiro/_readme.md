# Shiro

    权限校验
    
## shiroConfig    
    
    shiroFilter:
    
        配置过滤路径、不过滤路径、自定义过滤器.
    
    securityManager:
    
        web安全管理器，配置自定义的Realm
        
## ShiroRealm

    doGetAuthenticationInfo:
    
        登录校验，判断访问时是否是登录状态(登录接口需要把用户信息写入Shiro.SecurityUtils)
    
    doGetAuthorizationInfo:
    
        权限校验，判断访问接口时，账号是否有权限        
         
        接口权限：
        
            设置用户权限：info.addStringPermissions(Collection<String>);
                    
            设置角色权限：info.addRoles(Collection<String>);
        
            判断角色权限：@RequiresRoles("***")
        
            判断用户权限：@RequiresPermissions("****")
            
## ShiroUtils

    login:
        
      Shiro.SecurityUtils登录,用户信息写入Shiro  