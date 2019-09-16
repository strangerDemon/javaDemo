package com.learn.demo.Controller;

import com.learn.demo.Entity.ClientAppEntity;
import com.learn.demo.Model.ResultModel;
import com.learn.demo.Service.ClientAppService;
import com.learn.demo.Utils.ResultUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author demo
 * @date 2019/9/16 14:33
 * @description
 */
@RestController
public class ClientAppController {
    @Resource
    private ClientAppService clientAppService;

    @RequestMapping("/GetAllClientApp")
    public ResultModel GetAllClientApp(){
        List<ClientAppEntity> list=clientAppService.findAll();
        return ResultUtils.isOK(list);
    }
}
