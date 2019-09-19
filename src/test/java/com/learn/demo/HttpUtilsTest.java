package com.learn.demo;

import com.alibaba.fastjson.JSONObject;
import com.learn.demo.Utils.HttpUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author demo
 * @date 2019/9/19 16:14
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HttpUtilsTest {
    @Resource
    private HttpUtils httpUtils;

    @Test
    public void PostTest() {
        try {
            JSONObject json = new JSONObject();
            json.put("ST", "");
            json.put("service", "");
            json.put("code", "");
            json.put("sessionIdKey", "");
            json.put("sessionIdValue", "");
            String url = "http://localhost:19433/cas/VerifyTicket";
            String result = httpUtils.HttpPostForString(url, json);
            System.out.println("result:"+result);
        } catch (Exception ex) {
            ex.getStackTrace();
        }
    }
}
