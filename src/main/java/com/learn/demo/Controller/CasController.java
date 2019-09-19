package com.learn.demo.Controller;

import com.learn.demo.Model.ResultModel;
import com.learn.demo.Utils.ResultUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author demo
 * @date 2019/9/19 9:37
 * @description Cas登录接口
 */
@RestController
@RequestMapping("/Cas")
public class CasController {

    @RequestMapping("/CheckLogin")
    public ResultModel CheckLogin(){
        return ResultUtils.isOK();
    }
}
