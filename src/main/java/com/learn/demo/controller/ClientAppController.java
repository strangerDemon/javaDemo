package com.learn.demo.controller;

import com.learn.demo.entity.ClientAppEntity;
import com.learn.demo.entity.UserEntity;
import com.learn.demo.model.MyExceptionModel;
import com.learn.demo.model.ResultModel;
import com.learn.demo.service.ClientAppService;
import com.learn.demo.utils.JsonUtils;
import com.learn.demo.utils.RedisUtils;
import com.learn.demo.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClientApp 客户端表的增删改查.
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/9/16 14:33
 */
@Api(value = "CAS客户端管理接口")
@RestController
@RequestMapping("/ClientApp")
public class ClientAppController {

  @Resource
  private HttpSession session;

  @Resource
  private RedisUtils redisUtils;

  @Resource
  private ClientAppService clientAppService;

  //region 查询

  /**
   * 获取客户端列表.
   *
   * @param data     过滤参数
   * @param pageable 分页参数
   * @return 客户端列表
   */
  @ApiOperation(value = "获取接入的客户端")
  @RequestMapping("/GetList")
  public ResultModel getClientAppList(@RequestBody Map data, Pageable pageable) {
    return ResultUtils.isOK(clientAppService.findAll(data, pageable));
  }
  //endregion

  /**
   * 获取账户权限类的客户端.
   *
   * @return 客户端列表
   */
  @ApiOperation(value = "获取权限客户端")
  @RequestMapping("/GetAuthClientApp")
  public ResultModel getAuthClientApp() {
    UserEntity user = JsonUtils.toBean(redisUtils.get(session.getId()), UserEntity.class);
    if (user == null) {
      throw new MyExceptionModel("账号未登录");
    }
    List<ClientAppEntity> list = clientAppService.findAuthClients(user.getUserId());
    return ResultUtils.isOK(list);
  }

  /**
   * 创建客户端.
   *
   * @param entity 客户端
   * @return 客户端
   */
  @ApiOperation(value = "创建客户端")
  @RequestMapping("AddClientApp")
  public ResultModel addClientApp(@RequestBody ClientAppEntity entity) {
    return ResultUtils.isOK(clientAppService.addClientApp(entity));
  }
}
