package com.learn.demo.controller;

import com.learn.demo.entity.ClientAppAuthEntity;
import com.learn.demo.model.ResultModel;
import com.learn.demo.service.ClientAppAuthService;
import com.learn.demo.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClientAppAuth 用户的客户端权限表的增删改查.
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/9/16 14:34
 */
@Api("CAS客户端权限管理接口")
@RestController
@RequestMapping("/ClientAppAuth")
public class ClientAppAuthController {

  @Resource
  private ClientAppAuthService clientAppAuthService;

  @ApiOperation(value = "获取客户端的权限用户")
  @RequestMapping("/GetClientUsers")
  public ResultModel getClientUsers(String clientId) {
    List<ClientAppAuthEntity> list = clientAppAuthService.findByClientAppId(clientId);
    return ResultUtils.isOK(list);
  }

  @ApiOperation(value = "获取用户的权限客户端")
  @RequestMapping("/GetUserClients")
  public ResultModel getUserClients(String userId) {
    List<ClientAppAuthEntity> list = clientAppAuthService.findByUserId(userId);
    return ResultUtils.isOK(list);
  }
}
