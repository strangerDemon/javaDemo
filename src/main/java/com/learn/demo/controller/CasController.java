package com.learn.demo.controller;

import com.learn.demo.entity.ClientAppEntity;
import com.learn.demo.entity.UserEntity;
import com.learn.demo.model.RedisClientModel;
import com.learn.demo.model.RedisUserModel;
import com.learn.demo.model.ResultModel;
import com.learn.demo.service.ClientAppService;
import com.learn.demo.utils.CasUtils;
import com.learn.demo.utils.JsonUtils;
import com.learn.demo.utils.RedisUtils;
import com.learn.demo.utils.ResultUtils;
import java.util.Date;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Cas登录接口.
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/9/19 9:37
 */
@RestController
@RequestMapping("/Cas")
public class CasController {

  @Resource
  private CasUtils casUtils;

  @Resource
  private RedisUtils redisUtils;

  @Resource
  private ClientAppService clientAppService;

  @Resource
  private HttpSession session;

  /**
   * 根据session判断用户是否登录.
   *
   * @return 用户信息
   */
  @RequestMapping("/IsLogin")
  public ResultModel isLogin() {
    String userJson = redisUtils.get(session.getId());
    if (userJson == null || userJson.equals("")) {
      return ResultUtils.isError("未登录");
    }
    RedisUserModel redisUser = JsonUtils.toBean(userJson, RedisUserModel.class);
    return ResultUtils.isOK(redisUser);
  }

  /**
   * 获取票据.
   *
   * @return 票据
   */
  @RequestMapping("/GetTicket")
  public ResultModel getTicket(@RequestParam("service") String service,
      @RequestParam("code") String code) {
    String userJson = redisUtils.get(session.getId());
    if (userJson == null || userJson.equals("")) {
      return ResultUtils.isError("未登录,请先登录");
    }
    ClientAppEntity client = clientAppService.getByAppLoginUrl(service);
    RedisUserModel redisUser = JsonUtils.toBean(userJson, RedisUserModel.class);
    String ticket = casUtils.createTicket();
    RedisClientModel redisClient = new RedisClientModel();
    redisClient.setAppId(client.getAppId());
    redisClient.setAppLoginUrl(client.getAppLoginUrl());
    redisClient.setAppName(client.getAppName());
    redisClient.setSessionIdKey("");
    redisClient.setSessionIdValue("");
    redisClient.setCode(code);
    redisClient.setTicket(ticket);
    redisClient.setTicketCreateTime(new Date());
    redisClient.setTicketValidated(-1);
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
