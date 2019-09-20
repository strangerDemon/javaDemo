package com.learn.demo.controller;

import com.learn.demo.entity.UserEntity;
import com.learn.demo.model.ResultModel;
import com.learn.demo.service.UserService;
import com.learn.demo.utils.RedisUtils;
import com.learn.demo.utils.ResultUtils;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @author demo
 * @version 1.0.0
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
  public ResultModel getAllUser() {
    return ResultUtils.isOK(userService.findAll());
  }

  @RequestMapping("/GetUser")
  public ResultModel getUser(String userId) {
    return ResultUtils.isOK(userService.getOne(userId));
  }

  @RequestMapping("/AddUser")
  public ResultModel addUser(@RequestBody UserEntity entity) {
    return ResultUtils.isOK(userService.addUser(entity));
  }

  @RequestMapping("/UserLogin")
  public ResultModel userLogin(@RequestBody UserEntity entity) {
    return ResultUtils.isOK(userService.checkLogin(entity));
  }
}
