package com.learn.demo.Model;


import com.learn.demo.Utils.YmlFactoryUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author demo
 * @date 2019/9/16 19:22
 * @description 系统配置参数
 */
@Component
@PropertySource(value = {"classpath:system.yml"},factory = YmlFactoryUtils.class,encoding = "utf-8") //引入配置文件路径,只支持.properties
//@PropertySource(value = {"classpath:system.properties"},encoding = "utf-8")
@ConfigurationProperties(prefix = "system") //和配置文件绑定，类中属性和配置文件必须一致才能注入
public class SystemConfigModel {
    //@Value配合 @PropertySource
    //@Value("${system.redisTimeOut}")
    private Integer redisTimeOut;

    private String encryptKey;

    public Integer getRedisTimeOut() {
        return redisTimeOut;
    }

    public void setRedisTimeOut(Integer redisTimeOut) {
        this.redisTimeOut = redisTimeOut;
    }

    public String getEncryptKey() {
        return encryptKey;
    }

    public void setEncryptKey(String encryptKey) {
        this.encryptKey = encryptKey;
    }

    @Override
    public String toString() {
        return "SystemConfigModel{" +
                "redisTimeOut=" + redisTimeOut +
                ", encryptKey='" + encryptKey + '\'' +
                '}';
    }
}