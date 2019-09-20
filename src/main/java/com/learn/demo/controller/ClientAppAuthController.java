package com.learn.demo.controller;

import com.learn.demo.entity.ClientAppAuthEntity;
import com.learn.demo.model.ResultModel;
import com.learn.demo.service.ClientAppAuthService;
import com.learn.demo.utils.ResultUtils;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @author demo
 * @date 2019/9/16 14:34
 * @description ClientAppAuth 用户的客户端权限表的增删改查
 * @version 1.0.0
 */
@RestController
@RequestMapping("/ClientAppAuth")
public class ClientAppAuthController {

  @Resource
  private ClientAppAuthService clientAppAuthService;

  @RequestMapping("/GetClientUsers")
  public ResultModel getClientUsers(String clientId) {
    List<ClientAppAuthEntity> list = clientAppAuthService.findByClientAppId(clientId);
    return ResultUtils.isOK(list);
  }

  @RequestMapping("/GetUserClients")
  public ResultModel getUserClients(String userId) {
    List<ClientAppAuthEntity> list = clientAppAuthService.findByUserId(userId);
    return ResultUtils.isOK(list);
  }
}
