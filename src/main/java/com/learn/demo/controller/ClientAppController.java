package com.learn.demo.controller;

import com.learn.demo.entity.ClientAppEntity;
import com.learn.demo.model.ResultModel;
import com.learn.demo.service.ClientAppService;
import com.learn.demo.utils.ResultUtils;
import java.util.List;
import javax.annotation.Resource;
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
  private ClientAppService clientAppService;

  @RequestMapping("/GetAllClientApp")
  public ResultModel getAllClientApp() {
    List<ClientAppEntity> list = clientAppService.findAll();
    return ResultUtils.isOK(list);
  }
}
