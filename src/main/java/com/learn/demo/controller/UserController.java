package com.learn.demo.controller;

import com.learn.demo.entity.CasLogEntity;
import com.learn.demo.entity.UserEntity;
import com.learn.demo.model.RedisUserModel;
import com.learn.demo.model.ResultModel;
import com.learn.demo.service.CasLogService;
import com.learn.demo.service.UserService;
import com.learn.demo.utils.JsonUtils;
import com.learn.demo.utils.RedisUtils;
import com.learn.demo.utils.ResultUtils;
import com.learn.demo.utils.shiro.ShiroUtils;
import java.util.Date;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
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
  private HttpSession session;
  @Resource
  private UserService userService;
  @Resource
  private CasLogService casLogService;
  @Resource
  private RedisUtils redisUtils;
  @Resource
  private ShiroUtils shiroUtils;

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

  /**
   * 用户登录接口.
   *
   * @param entity 登录信息
   * @return 用户信息
   */
  @RequestMapping("/UserLogin")
  public ResultModel userLogin(@RequestBody UserEntity entity) {
    String userJson = redisUtils.get(session.getId());
    RedisUserModel redisUser;
    if (userJson == null || userJson.equals("")) {
      UserEntity user = userService.userLogin(entity);
      redisUser = new RedisUserModel();
      redisUser.setAccount(user.getAccount());
      redisUser.setUserId(user.getUserId());
      redisUser.setUserName(user.getRealName());
      redisUser.setPassword(user.getPassword());
      redisUser.setLogTime(new Date());
      //casLog日志
      CasLogEntity casLog = casLogService.createCasLog(session.getId(), user);
      if (casLog != null) {
        redisUser.setCasLogId(casLog.getCasLogId());
      }
      redisUtils.set(session.getId(), JsonUtils.toJson(redisUser));//存redis
      shiroUtils.login(user);//存shiro
    } else {
      redisUser = JsonUtils.toBean(userJson, RedisUserModel.class);
    }
    return ResultUtils.isOK(redisUser);
  }
}
