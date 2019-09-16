package com.learn.demo.Controller;

import com.learn.demo.Entity.CasLogEntity;
import com.learn.demo.Model.ResultModel;
import com.learn.demo.Service.CasLogService;
import com.learn.demo.Utils.ResultUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author demo
 * @date 2019/9/16 14:35
 * @description
 */
@RestController
public class CasLogController {
    @Resource
    private CasLogService casLogService;

    @RequestMapping("/GetAllCasLog")
    public ResultModel GetAllCasLog(){
        List<CasLogEntity> list=casLogService.findAll();
        return ResultUtils.isOK(list);
    }
}
