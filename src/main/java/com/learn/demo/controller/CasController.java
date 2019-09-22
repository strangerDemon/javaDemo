package com.learn.demo.controller;

import com.learn.demo.entity.UserEntity;
import com.learn.demo.model.ResultModel;
import com.learn.demo.utils.CasUtils;
import com.learn.demo.utils.JsonUtils;
import com.learn.demo.utils.RedisUtils;
import com.learn.demo.utils.ResultUtils;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @author demo
 * @date 2019/9/19 9:37
 * @description Cas登录接口
 * @version 1.0.0
 */
@RestController
@RequestMapping("/Cas")
public class CasController {

  @Resource
  private CasUtils casUtils;

  @Resource
  private RedisUtils redisUtils;

  @Resource
  private HttpSession session;

  /**
   * 根据session判断用户是否登录.
   *
   * @return 用户信息
   */
  @RequestMapping("/CheckLogin")
  public ResultModel checkLogin() {
    UserEntity user = JsonUtils.toBean(redisUtils.get(session.getId()), UserEntity.class);
    if (user == null) {
      return ResultUtils.isError("未登录");
    }
    return ResultUtils.isOK(user);
  }

  /**
   * 获取票据.
   * @return 票据
   */
  @RequestMapping("/GetTicket")
  public ResultModel getTicket() {
    UserEntity user = JsonUtils.toBean(redisUtils.get(session.getId()), UserEntity.class);
    if (user == null) {
      return ResultUtils.isError("未登录,请先登录");
    }
    casUtils.createTicket();
    return ResultUtils.isOK();
  }

  /**
   * 校验颁发的ticket的正确性.
   *
   * @param o 验证信息
   * @return 用户信息
   */
  @RequestMapping("/CheckTicket")
  public ResultModel checkTicket(@RequestBody Object o) {
    return ResultUtils.isOK();
  }
}
