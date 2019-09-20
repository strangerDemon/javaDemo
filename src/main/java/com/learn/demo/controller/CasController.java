package com.learn.demo.controller;

import com.learn.demo.model.ResultModel;
import com.learn.demo.utils.ResultUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @author demo
 * @date 2019/9/19 9:37
 * @description Cas登录接口
 * @version 1.0.0
 */
@RestController
@RequestMapping("/Cas")
public class CasController {

  @RequestMapping("/CheckLogin")
  public ResultModel checkLogin() {
    return ResultUtils.isOK();
  }
}
