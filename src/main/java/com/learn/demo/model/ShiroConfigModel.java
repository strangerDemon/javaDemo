package com.learn.demo.model;

import com.learn.demo.utils.YmlFactoryUtils;
import java.util.List;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/*
 * @author demo
 * @version 1.0.0
 * @date 2019/9/19 13:55
 * @description
 */
@Data
@Component
@PropertySource(value = {
    "classpath:shiroConfig.yml"}, factory = YmlFactoryUtils.class, encoding = "utf-8")
@ConfigurationProperties(prefix = "filter")
public class ShiroConfigModel {

  //是否设置url
  private boolean isSetUrl;
  //登录地址
  private String loginUrl;
  //成功地址
  private String successUrl;
  //无权限地址
  private String noAuthorityUrl;

  //不过滤路径列表
  private List<String> unFilterList;
  //过滤列表
  private List<String> filterList;

}
