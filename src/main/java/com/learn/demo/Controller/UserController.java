package com.learn.demo.Controller;

import com.learn.demo.Model.ResultModel;
import com.learn.demo.Entity.UserEntity;
import com.learn.demo.Service.UserService;
import com.learn.demo.Utils.ResultUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
/**
 * @author demo
 * @date 2019/9/10 16:40
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/GetAllUser")
    public ResultModel GetAllUser(){
        List<UserEntity> list = userService.findAll();
        return ResultUtils.isOK(list);
    }

    @RequestMapping("/GetUser")
    public ResultModel GetUser(String userId){
        UserEntity entity = userService.getOne(userId);
        return ResultUtils.isOK(entity);
    }
}
