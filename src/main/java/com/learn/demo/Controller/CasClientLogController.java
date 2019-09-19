package com.learn.demo.Controller;

import com.learn.demo.Entity.CasClientLogEntity;
import com.learn.demo.Model.ResultModel;
import com.learn.demo.Service.CasClientLogService;
import com.learn.demo.Utils.ResultUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author demo
 * @date 2019/9/16 14:35
 * @description 对应CasClientLog 客户端登录日志表 的增删改查
 */
@RestController
@RequestMapping("/CasClientLog")
public class CasClientLogController {
    @Resource
    private CasClientLogService casClientLogService;

    @RequestMapping("/GetAllCasClientLog")
    public ResultModel GetAllCasClientLog(){
        List<CasClientLogEntity> list=casClientLogService.findAll();
        return ResultUtils.isOK(list);
    }
}
