package com.learn.demo.model;

import com.learn.demo.utils.YmlFactoryUtils;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 类描述.
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/11/28 15:00
 */
@Data
@Component
@PropertySource(value = {
    "classpath:system.yml"}, factory = YmlFactoryUtils.class, encoding = "utf-8")
@ConfigurationProperties(prefix = "thread")
public class ThreadConfigModel {
  private Integer corePoolSize;

  private Integer maxPoolSize;

  private Integer queueCapacity;

  private Integer keepAliveSeconds;

  private String namePrefix;

  private Boolean waitForTasksToCompleteOnShutdown;

  private Integer waitTerminationSeconds;
}
