package com.learn.demo.controller;

import com.learn.demo.model.ResultModel;
import com.learn.demo.service.ClientAppAuthService;
import com.learn.demo.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClientAppAuth 用户的客户端权限表的增删改查.
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/9/16 14:34
 */
@Api(value = "CAS客户端权限管理接口")
@RestController
@RequestMapping("/ClientAppAuth")
public class ClientAppAuthController {

  @Resource
  private ClientAppAuthService clientAppAuthService;

  //region 查询
  @ApiOperation(value = "获取分页列表")
  @RequestMapping("/GetList")
  public ResultModel getClientAppAuthList(@RequestBody Map data, Pageable pageable) {
    return ResultUtils.isOK(clientAppAuthService.findAll(data, pageable));
  }
  //endregion
}
