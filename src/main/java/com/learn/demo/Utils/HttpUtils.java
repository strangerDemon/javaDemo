package com.learn.demo.Utils;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author demo
 * @date 2019/9/19 9:11
 * @description http请求工具类
 */
@Component
public class HttpUtils {

    private RestTemplate rest = new RestTemplate();

    public JSONObject HttpPostForJSON(String url, JSONObject param){
        return rest.postForObject(url,param,JSONObject.class);
    }

    public JSONObject HttpGetForJSON(String url,JSONObject param){
        return rest.getForObject(url,JSONObject.class,param);
    }

    public String HttpPostForString(String url, JSONObject param){
        return rest.postForObject(url,param,String.class);
    }

    public String HttpGetForString(String url,JSONObject param){
        return rest.getForObject(url,String.class,param);
    }

}
