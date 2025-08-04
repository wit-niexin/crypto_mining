package com.mining.crypto.controller;

import com.mining.crypto.response.ResponseBean;
import com.mining.crypto.service.IUserBenefitsService;
import com.mining.crypto.vo.UserBenefits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;

@Api(tags = "用户收益管理模块")
@RestController
@RequestMapping("/user_benefits")
public class UserBenefitsController {

    @Autowired
    private IUserBenefitsService userBenefitsService;

    @ApiOperation(value = "获得全部收益数据列表")
    @GetMapping("/getAll")
    public ResponseBean<List> getAll() {
        List<UserBenefits> userBenefits = userBenefitsService.list();
        return new ResponseBean<>(userBenefits);
    }

}