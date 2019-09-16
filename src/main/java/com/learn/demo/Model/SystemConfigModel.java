package com.learn.demo.Model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author demo
 * @date 2019/9/16 19:22
 * @description 系统配置参数
 */
@Component
//@PropertySource(value = {"classpath:resources/systemConfig.yml"}) //引入配置文件路径
@ConfigurationProperties(prefix = "system") //和配置文件绑定，类中属性和配置文件必须一致才能注入
public class SystemConfigModel {
    //@Value配合 @PropertySource
    //@value("${system.redisTimeOut")
    private Integer redisTimeOut;


    public Integer getRedisTimeOut() {
        return redisTimeOut;
    }

    public void setRedisTimeOut(Integer redisTimeOut) {
        this.redisTimeOut = redisTimeOut;
    }

    @Override
    public String toString() {
        return "SystemConfigModel{" +
                "redisTimeOut=" + redisTimeOut +
                '}';
    }
}
