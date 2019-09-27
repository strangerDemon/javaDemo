package com.learn.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis-plus 配置文件.
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/9/27 16:17
 */
@Configuration
@MapperScan("com.learn.demo.mapper") //=>每个"com.learn.demo.mapper"类 @Mapper
public class MybatisPlusConfig {

}
