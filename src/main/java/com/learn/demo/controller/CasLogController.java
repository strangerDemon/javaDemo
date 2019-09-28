package com.learn.demo.controller;

import com.learn.demo.model.ResultModel;
import com.learn.demo.service.CasLogService;
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
 * CasLog Cas登录日志表的增删改查.
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/9/16 14:35
 */
@Api(value = "CAS登录日志管理接口")
@RestController
@RequestMapping("/CasLog")
public class CasLogController {

  @Resource
  private CasLogService casLogService;

  /**
   * cas登录日志分页查询.
   *
   * @param data     过滤条件
   * @param pageable 分页参数
   * @return 日志列表
   */
  @ApiOperation(value = "获取cas登录日志")
  @RequestMapping("/GetList")
  public ResultModel getCasLogList(@RequestBody Map data, Pageable pageable) {
    return ResultUtils.isOK(casLogService.findAll(data, pageable));
  }
}
