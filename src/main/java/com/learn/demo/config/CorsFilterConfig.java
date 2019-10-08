package com.learn.demo.config;

import com.learn.demo.entity.ClientAppEntity;
import com.learn.demo.model.SystemConfigModel;
import com.learn.demo.service.ClientAppService;
import java.util.List;
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
public class CorsFilterConfig {

  @Resource
  private SystemConfigModel systemConfigModel;

  @Resource
  private ClientAppService clientAppService;

  /**
   * 过滤器.
   *
   * @return FilterRegistrationBean
   */
  @Bean
  public FilterRegistrationBean corsFilter() {
    CorsConfiguration config = new CorsConfiguration();
    config.setAllowCredentials(true);
    config.addAllowedHeader("*");
    config.addAllowedMethod("*");
    //cas 前端
    String[] casFrontUrls = systemConfigModel.getCasFrontUrl().split(",");
    for (String casUrl : casFrontUrls) {
      config.addAllowedOrigin(casUrl);
    }
    //客户端
    List<ClientAppEntity> clients = clientAppService.findAll();
    for (ClientAppEntity client : clients) {
      config.addAllowedOrigin(client.getAppLoginUrl());
    }

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", config);

    FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
    bean.setOrder(0);
    return bean;
  }

}
