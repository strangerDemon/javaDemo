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
@ConfigurationProperties(prefix = "system")
public class SystemConfigModel {

  private Integer redisTimeOut;

  private String encryptKey;

  private String casFrontUrl = "";

  private Integer ticketEffectiveTimeOut;
}