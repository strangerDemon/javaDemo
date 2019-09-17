package com.learn.demo.Controller;

import com.alibaba.fastjson.JSONObject;
import com.learn.demo.Model.MyExceptionModel;
import com.learn.demo.Model.ResultModel;
import com.learn.demo.Entity.UserEntity;
import com.learn.demo.Service.UserService;
import com.learn.demo.Utils.EncryptUtils;
import com.learn.demo.Utils.RedisUtils;
import com.learn.demo.Utils.ResultUtils;
import netscape.javascript.JSObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author demo
 * @date 2019/9/10 16:40
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private RedisUtils redisUtils;

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

    @RequestMapping("/AddUser")
    public ResultModel AddUser(@RequestBody UserEntity entity){
        UserEntity user=userService.getByAccount(entity.getAccount());
        if(user!=null){
            throw new MyExceptionModel("账号:"+entity.getAccount()+"已存在！");
        }
        entity.setUserId(UUID.randomUUID().toString());
        entity.setPassword(EncryptUtils.encrypt(entity.getPassword()));
        return ResultUtils.isOK(userService.saveAndFlush(entity));
    }

    @RequestMapping("/UserLogin")
    public ResultModel UserLogin(@RequestParam Map<String,String>param) {
        String encryptPS = EncryptUtils.encrypt(param.get("password)"));
        UserEntity entity = userService.getByAccount(param.get("account"));
        if (entity == null) {
            throw new MyExceptionModel("账号不存在!");
        }
        if (encryptPS.equals(entity.getPassword())) {
            throw new MyExceptionModel("密码不正确!");
        }
        return ResultUtils.isOK(userService.saveAndFlush(entity));
    }
}
