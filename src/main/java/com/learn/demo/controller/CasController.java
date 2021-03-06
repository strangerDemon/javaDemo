package com.learn.demo.controller;

import com.learn.demo.entity.ClientAppEntity;
import com.learn.demo.model.RedisUserModel;
import com.learn.demo.model.ResultModel;
import com.learn.demo.service.ClientAppService;
import com.learn.demo.utils.CasUtils;
import com.learn.demo.utils.ResultUtils;
import com.learn.demo.utils.redis.RedisUserUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Cas登录接口.
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/9/19 9:37
 */
@Api(value = "CAS管理接口")
@RestController
@RequestMapping("Cas")
public class CasController {

  @Resource
  private CasUtils casUtils;

  @Resource
  private RedisUserUtils redisUserUtils;

  @Resource
  private ClientAppService clientAppService;

  @Resource
  private HttpSession session;

  /**
   * 根据session判断用户是否登录.
   *
   * @return 用户信息
   */
  @ApiOperation(value = "客户端是否登录")
  @RequestMapping("IsLogin")
  public ResultModel isLogin() {
    RedisUserModel redisUser = redisUserUtils.getUserOfSessionId(session.getId());
    if (redisUser == null) {
      return ResultUtils.isOk("未登录");
    }
    return ResultUtils.isOk(redisUser);
  }

  /**
   * 获取票据.
   *
   * @return 票据
   */
  @ApiOperation(value = "客户端获取票据")
  @RequestMapping(value = "GetTicket", method = RequestMethod.GET)
  public ResultModel getTicket(@RequestBody Map data) {
    //数据库中的客户端对象
    ClientAppEntity client = clientAppService.checkService(data);

    return ResultUtils.isOk(casUtils.getTicket(session.getId(), client, data));
  }

  /**
   * 校验颁发的ticket的正确性.
   *
   * @param data 验证信息
   * @return 用户信息
   */
  @ApiOperation(value = "客户端校验票据")
  @RequestMapping("VerifyTicket")
  public ResultModel verifyTicket(@RequestBody Map data) {
    RedisUserModel redisUser = casUtils.verifyTicket(data);
    redisUser.setClients(null);
    return ResultUtils.isOk(redisUser);
  }
}
