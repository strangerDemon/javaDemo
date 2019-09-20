package com.learn.demo.controller;

import com.learn.demo.entity.CasLogEntity;
import com.learn.demo.model.ResultModel;
import com.learn.demo.service.CasLogService;
import com.learn.demo.utils.ResultUtils;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @author demo
 * @version 1.0.0
 * @date 2019/9/16 14:35
 * @description CasLog Cas登录日志表的增删改查
 */
@RestController
@RequestMapping("/CasLog")
public class CasLogController {

  @Resource
  private CasLogService casLogService;

  @RequestMapping("/GetAllCasLog")
  public ResultModel getAllCasLog() {
    List<CasLogEntity> list = casLogService.findAll();
    return ResultUtils.isOK(list);
  }
}
