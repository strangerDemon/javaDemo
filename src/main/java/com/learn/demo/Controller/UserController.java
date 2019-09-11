package com.learn.demo.Controller;

/**
 * @author demo
 * @date 2019/9/10 16:40
 */

import com.learn.demo.Model.UserModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @RequestMapping("/GetUser")
    public List<UserModel> GetUser(){
        UserModel user =new UserModel();
        user.setAccount("demo");
        user.setName("demo");
        user.setPassword("123465");
        user.setSex("man");
        user.setAge(18);
        user.setDescription("this is a man of name demo");

        UserModel girl =new UserModel();
        girl.setAccount("lisa");
        girl.setName("lisa");
        girl.setPassword("123465");
        girl.setSex("woman");
        girl.setAge(18);

        List<UserModel> list=new ArrayList<UserModel>();
        list.add(user);
        list.add(girl);

        return list;
    }
}
