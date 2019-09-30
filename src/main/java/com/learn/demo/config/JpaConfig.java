package com.learn.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * JPA 配置文件.
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/9/30 8:37
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.learn.demo.repository")
public class JpaConfig {

}
