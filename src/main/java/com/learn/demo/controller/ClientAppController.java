package com.learn.demo.controller;

import com.learn.demo.entity.ClientAppEntity;
import com.learn.demo.entity.UserEntity;
import com.learn.demo.model.MyExceptionModel;
import com.learn.demo.model.ResultModel;
import com.learn.demo.service.ClientAppService;
import com.learn.demo.utils.JsonUtils;
import com.learn.demo.utils.RedisUtils;
import com.learn.demo.utils.ResultUtils;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClientApp 客户端表的增删改查.
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/9/16 14:33
 */
@RestController
@RequestMapping("/ClientApp")
public class ClientAppController {

  @Resource
  private HttpSession session;

  @Resource
  private RedisUtils redisUtils;

  @Resource
  private ClientAppService clientAppService;

  @RequestMapping("/GetAllClientApp")
  public ResultModel getAllClientApp() {
    List<ClientAppEntity> list = clientAppService.findAll();
    return ResultUtils.isOK(list);
  }

  /**
   * 获取账户权限类的客户端.
   *
   * @return 客户端列表
   */
  @RequestMapping("/GetAuthClientApp")
  public ResultModel getAuthClientApp() {
    UserEntity user = JsonUtils.toBean(redisUtils.get(session.getId()), UserEntity.class);
    if (user == null) {
      throw new MyExceptionModel("账号未登录");
    }
    List<ClientAppEntity> list = clientAppService.findAuthClients(user.getUserId());
    return ResultUtils.isOK(list);
  }
}
