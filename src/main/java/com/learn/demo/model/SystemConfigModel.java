package com.learn.demo.model;

import com.learn.demo.utils.YmlFactoryUtils;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 系统配置参数.
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/9/16 19:22
 */
@Data
@Component
@PropertySource(value = {
    "classpath:system.yml"}, factory = YmlFactoryUtils.class, encoding = "utf-8")
//引入配置文件路径,只支持.properties
//@PropertySource(value = {"classpath:system.properties"},encoding = "utf-8")
@ConfigurationProperties(prefix = "system") //和配置文件绑定，类中属性和配置文件必须一致才能注入
public class SystemConfigModel {

  //@Value配合 @PropertySource
  //@Value("${system.redisTimeOut}")
  private Integer redisTimeOut;

  private String encryptKey;

  private String casFrontUrl = "";
}