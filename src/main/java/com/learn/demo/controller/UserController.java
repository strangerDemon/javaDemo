package com.learn.demo.controller;

import com.learn.demo.entity.CasLogEntity;
import com.learn.demo.entity.UserEntity;
import com.learn.demo.model.RedisUserModel;
import com.learn.demo.model.ResultModel;
import com.learn.demo.service.CasLogService;
import com.learn.demo.service.UserService;
import com.learn.demo.utils.ResultUtils;
import com.learn.demo.utils.redis.RedisUserUtils;
import com.learn.demo.utils.shiro.ShiroUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Date;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * BaseUser 用户表的增删改查.
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/9/10 16:40
 */
@Api(value = "用户管理接口")
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
  private RedisUserUtils redisUserUtils;
  @Resource
  private ShiroUtils shiroUtils;

  //region  查询

  /**
   * 根据用户ID获取用户.
   *
   * @param userId 用户ID
   * @return 用户
   */
  @ApiOperation(value = "获取用户")
  @RequestMapping("/GetById")
  public ResultModel getUser(String userId) {
    return ResultUtils.isOK(userService.getOne(userId));
  }

  /**
   * 获取用户分页列表.
   *
   * @param data 请求参数
   * @param page 分页参数
   * @return 用户列表
   */
  @ApiOperation(value = "获取用户分页列表")
  @RequestMapping("GetList")
  public ResultModel getUserList(@RequestBody Map data, Pageable page) {
    return ResultUtils.isOK(userService.findAll(data, page));
  }
  //endregion

  /**
   * 创建用户.
   *
   * @param entity 用户
   * @return 用户
   */
  @ApiOperation(value = "创建用户")
  @RequestMapping("/Add")
  public ResultModel addUser(@RequestBody UserEntity entity) {
    return ResultUtils.isOK(userService.addUser(entity));
  }

  /**
   * 用户登录接口.
   *
   * @param entity 登录信息
   * @return 用户信息
   */
  @ApiOperation(value = "用户登录")
  @RequestMapping("/Login")
  public ResultModel userLogin(@RequestBody UserEntity entity) {
    RedisUserModel redisUser = redisUserUtils.getUserOfSessionId(session.getId());
    if (redisUser == null) {
      UserEntity user = userService.userLogin(entity);
      redisUser = new RedisUserModel();
      redisUser.setAccount(user.getAccount());
      redisUser.setUserId(user.getUserId());
      redisUser.setUserName(user.getRealName());
      redisUser.setPassword(user.getPassword());
      redisUser.setLogTime(new Date());
      //casLog日志
      CasLogEntity casLog = casLogService.addCasLog(session.getId(), user);
      if (casLog != null) {
        redisUser.setCasLogId(casLog.getCasLogId());
      }
      //存redis
      redisUserUtils.save(session.getId(), redisUser);
      //存shiro
      shiroUtils.login(user);
    }
    return ResultUtils.isOK(redisUser);
  }

  /**
   * 用户登出接口.
   *
   * @return info
   */
  @ApiOperation(value = "用户登出接口")
  @RequestMapping("/Logout")
  public ResultModel userLogout() {
    redisUserUtils.delete(session.getId());
    shiroUtils.logout();
    return ResultUtils.isOK("登出成功！");
  }
}
