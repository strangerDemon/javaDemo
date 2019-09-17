package com.learn.demo.Utils;

import com.learn.demo.Model.SystemConfigModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author demo
 * @date 2019/9/17 15:01
 * @description 加解密
 */
@Component
public class EncryptUtils {

    private final static Logger logger = LoggerFactory.getLogger(EncryptUtils.class);

    private static SystemConfigModel systemConfig;

    public EncryptUtils() {
        systemConfig =new SystemConfigModel();
    }

    public static String encrypt(String data){
        return encrypt(data,systemConfig.getEncryptKey());
    }

    public static String decrypt(String data){
        return decrypt(data,systemConfig.getEncryptKey());
    }

    /**
     * 加密
     * @param data 数据
     * @param key 公钥
     * @return 解密结果
     */
    private static String encrypt(String data,String key){
        return "";
    }

    /**
     * 解密
     * @param data 数据
     * @param key 公钥
     * @return 解密结果
     */
    private static String decrypt(String data,String key){
        return "";
    }
}
