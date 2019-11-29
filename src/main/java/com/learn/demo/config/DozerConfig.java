package com.learn.demo.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 对象间转换.
 * 以属性名关联 dozerBeanMapper.map(source,ToObject.class)
 * @author demo
 * @version 1.0.0
 * @date 2019/11/29 11:31
 */
@Configuration
public class DozerConfig {

  /**
   * 对象转换工具.
   * @return dozer
   */
  @Bean("dozerBeanMapper")
  public DozerBeanMapper dozerBeanMapper() {
    return new DozerBeanMapper();
  }
}
