package com.mining.crypto.controller.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mining.crypto.response.ResponseBean;
import com.mining.crypto.service.IUserBenefitService;
import com.mining.crypto.vo.UserBenefit;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "用户收益管理模块")
@RestController
@RequestMapping("/user_benefit")
public class A_UserBenefitController {

    @Autowired
    private IUserBenefitService userBenefitService;

    @ApiImplicitParams({@ApiImplicitParam(name = "current", value = "当前页", required = true),
                        @ApiImplicitParam(name = "size", value = "每页大小", required = true),
                        @ApiImplicitParam(name = "name", value = "用户名"),
                        @ApiImplicitParam(name = "status", value = "状态")})
    @ApiOperation(value = "获得分页收益列表")
    @GetMapping("/getAllPage")
    public ResponseBean<IPage<UserBenefit>> getAllPage(@RequestParam(defaultValue = "1") long current,
                                                       @RequestParam(defaultValue = "10") long size,
                                                       @RequestParam(required = false) String name,
                                                       @RequestParam(required = false) Integer status) {
        return new ResponseBean<>(userBenefitService.getAllUserBenefitsPage(current, size, name, status));
    }

}