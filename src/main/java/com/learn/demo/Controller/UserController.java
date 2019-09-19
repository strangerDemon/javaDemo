package com.learn.demo.Controller;

import com.learn.demo.Entity.UserEntity;
import com.learn.demo.Model.MyExceptionModel;
import com.learn.demo.Model.ResultModel;
import com.learn.demo.Service.UserService;
import com.learn.demo.Utils.EncryptUtils;
import com.learn.demo.Utils.RedisUtils;
import com.learn.demo.Utils.ResultUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @author demo
 * @date 2019/9/10 16:40
 * @description BaseUser 用户表的增删改查
 */
@RestController
@RequestMapping("/User")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private RedisUtils redisUtils;

    @RequestMapping("/GetAllUser")
    public ResultModel GetAllUser(){
        return ResultUtils.isOK(userService.findAll());
    }

    @RequestMapping("/GetUser")
    public ResultModel GetUser(String userId){
        return ResultUtils.isOK(userService.getOne(userId));
    }

    @RequestMapping("/AddUser")
    public ResultModel AddUser(@RequestBody UserEntity entity){
        return ResultUtils.isOK(userService.AddUser(entity));
    }

    @RequestMapping("/UserLogin")
    public ResultModel UserLogin(@RequestBody UserEntity entity) {
        return ResultUtils.isOK(userService.CheckLogin(entity));
    }
}
