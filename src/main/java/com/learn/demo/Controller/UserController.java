package com.learn.demo.Controller;

/**
 * @author demo
 * @date 2019/9/10 16:40
 */

import com.learn.demo.Model.UserModel;
import com.learn.demo.Service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @RequestMapping("/GetUser")
    public List<UserModel> GetUser(){
        UserService userService=new UserService();
        List<UserModel> list=new ArrayList<UserModel>();


        return list;
    }
}
