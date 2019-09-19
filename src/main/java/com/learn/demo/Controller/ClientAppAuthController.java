package com.learn.demo.Controller;

import com.learn.demo.Entity.ClientAppAuthEntity;
import com.learn.demo.Model.ResultModel;
import com.learn.demo.Service.ClientAppAuthService;
import com.learn.demo.Utils.ResultUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author demo
 * @date 2019/9/16 14:34
 * @description ClientAppAuth 用户的客户端权限表的增删改查
 */
@RestController
@RequestMapping("/ClientAppAuth")
public class ClientAppAuthController {
    @Resource
    private ClientAppAuthService clientAppAuthService;

    @RequestMapping("/GetClientUsers")
    public ResultModel GetClientUsers(String clientId){
        List<ClientAppAuthEntity> list=clientAppAuthService.findByClientAppId(clientId);
        return ResultUtils.isOK(list);
    }

    @RequestMapping("/GetUserClients")
    public ResultModel GetUserClients(String userId){
        List<ClientAppAuthEntity> list=clientAppAuthService.findByUserId(userId);
        return ResultUtils.isOK(list);
    }
}
