package com.learn.demo.Utils;

import com.learn.demo.Model.SystemConfigModel;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author demo
 * @date 2019/9/16 9:41
 * @description redis
 */
@Component
public class RedisUtils {
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private SystemConfigModel systemConfigModel;

    /**
     * 设置 长时间有效
     * @param key key
     * @param value value
     */
    public void set(String key, String value)
    {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    /**
     * 默认set 具有时效性
     * @param key key
     * @param value value
     */
    public void defaultSet(String key ,String value){
        set(key,value,systemConfigModel.getRedisTimeOut(),TimeUnit.SECONDS);
    }

    /**
     * 设置
     * @param key key
     * @param value value
     * @param time 时效性
     * @param timeUnit 单位
     */
    private void set(String key, String value, int time,TimeUnit timeUnit)
    {
        stringRedisTemplate.opsForValue().set(key, value ,time,timeUnit);
    }

    /**
     * 获取单体
     * @param key key
     * @return value
     */
    public String get(String key)
    {
        return stringRedisTemplate.opsForValue().get(key);
    }

    /**
     * key是否已经存在
     * @param key key
     * @return bool
     */
    public Boolean isExist(String key) {
        return stringRedisTemplate.hasKey(key);
    }

    /**
     * 移除单体
     * @param key key
     * @return bool
     */
    public Boolean delete(String key)
    {
        return stringRedisTemplate.delete(key);
    }

    /**
     * 获取所有主键
     * @return set
     */
    public Set<String> getAllKey()
    {
        String prefix = "*";
        return stringRedisTemplate.keys(prefix);
    }

    /**
     * 获取所有数据
     * @param keys keys
     * @return map
     */
    public Map getAll(Set<String> keys)
    {
        Map<String,String> data=new HashMap<>();
        for (String key : keys) {
            data.put(key,stringRedisTemplate.opsForValue().get(key));
        }
        return data;
    }


    /**
     * 清空所有缓存
     */
    public  void deleteAll() {
        String prefix = "*";
        Set<String> keys = stringRedisTemplate.keys(prefix);
        assert keys != null;
        for (String key : keys) {
            stringRedisTemplate.delete(key);
        }
    }
}
