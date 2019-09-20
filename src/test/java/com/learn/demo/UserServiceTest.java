package com.learn.demo;

import com.learn.demo.entity.UserEntity;
import com.learn.demo.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Resource
    private UserService userService;

    @Test
    public void getByAccount(){
        UserEntity user=userService.getByAccount("demo");
        Assert.assertEquals("123456",user.getPassword());
    }
}
