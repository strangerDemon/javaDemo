package com.learn.demo.utils;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * http请求工具类.
 * @author demo
 * @date 2019/9/19 9:11
 * @version 1.0.0
 */
@Component
public class HttpUtils {

  private RestTemplate rest = new RestTemplate();

  public JSONObject httpPost(String url, JSONObject param) {
    return rest.postForObject(url, param, JSONObject.class);
  }

  public JSONObject httpGet(String url, JSONObject param) {
    return rest.getForObject(url, JSONObject.class, param);
  }

  public String httpPostForString(String url, JSONObject param) {
    return rest.postForObject(url, param, String.class);
  }

  public String httpGetForString(String url, JSONObject param) {
    return rest.getForObject(url, String.class, param);
  }

}
