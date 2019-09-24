package com.learn.demo.aspect;

import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


/**
 * aop 截取所有调用接口.
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/9/15 19:34
 */

@Aspect
@Slf4j
@Component
public class HttpAspect {

  @Pointcut("execution(public * com.learn.demo.controller.*.*(..))")
  public void log() {

  }

  /**
   * 请求前.
   *
   * @param joinPoint 封装了SpringAop中切面方法的信息
   */
  @Before("log()")
  public void aspectBefore(JoinPoint joinPoint) {
    log.info("aspectBefore");

    ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
        .getRequestAttributes();
    assert attributes != null;
    HttpServletRequest request = attributes.getRequest();
    //url
    log.info("url={}", request.getRequestURL());
    //method
    log.info("method={}", request.getMethod());
    //ip
    log.info("ip={}", request.getRemoteAddr());
    //类
    log.info("class={}",
        joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    //类
    log.info("args={}", joinPoint.getArgs());
  }

  /**
   * 请求后.
   *
   * @param joinPoint joinPoint
   */
  @After("log()")
  public void aspectAfter(final JoinPoint joinPoint) {
    log.info("aspectAfter");
  }

  /*
   * 返回前
   *
   * @param object 返回参数
   */
  @AfterReturning(returning = "object", pointcut = "log()")
  public void aspectReturn(Object object) {
    log.info("response={}", object.toString());
  }
}
