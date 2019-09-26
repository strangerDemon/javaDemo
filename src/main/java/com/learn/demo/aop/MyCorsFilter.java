package com.learn.demo.aop;

import com.learn.demo.model.SystemConfigModel;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 跨越过滤处理.
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/9/24 16:21
 */
@Slf4j
@Component
@Configuration
public class MyCorsFilter {

  @Resource
  private SystemConfigModel systemConfigModel;

  /**
   * 过滤器.
   *
   * @return FilterRegistrationBean
   */
  @Bean
  public FilterRegistrationBean corsFilter() {
    //cas 前端
    CorsConfiguration config = new CorsConfiguration();
    config.setAllowCredentials(true);
    config.addAllowedOrigin(systemConfigModel.getCasFrontUrl());
    config.addAllowedHeader("*");
    config.addAllowedMethod("*");
    //todo:客户端

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", config);

    FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
    bean.setOrder(0);
    return bean;
  }

}
