package com.learn.demo.controller;

import com.learn.demo.entity.CasClientLogEntity;
import com.learn.demo.model.ResultModel;
import com.learn.demo.service.CasClientLogService;
import com.learn.demo.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 对应CasClientLog 客户端登录日志表 的增删改查.
 *
 * @author demo
 * @version 1.0.0
 * @date 2019/9/16 14:35
 */
@Api("CAS客户端登录日志管理接口")
@RestController
@RequestMapping("/CasClientLog")
public class CasClientLogController {

  @Resource
  private CasClientLogService casClientLogService;

  @ApiOperation(value = "获取客户端登录日志")
  @RequestMapping("/GetAllCasClientLog")
  public ResultModel getAllCasClientLog() {
    List<CasClientLogEntity> list = casClientLogService.findAll();
    return ResultUtils.isOK(list);
  }
}
