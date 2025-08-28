package com.mining.crypto.controller.admin;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mining.crypto.response.ResponseBean;
import com.mining.crypto.response.UserBenefitVO;
import com.mining.crypto.service.IUserBenefitService;
import com.mining.crypto.vo.UserBenefit;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Date;

@Api(tags = "用户收益管理模块")
@RestController
@RequestMapping("/user_benefit")
public class A_UserBenefitController {

    @Autowired
    private IUserBenefitService userBenefitService;

    @ApiImplicitParams({@ApiImplicitParam(name = "current", value = "当前页", required = true),
                        @ApiImplicitParam(name = "size", value = "每页大小", required = true),
                        @ApiImplicitParam(name = "name", value = "用户账号")})
    @ApiOperation(value = "获得分页收益列表1")
    @GetMapping("/getAllPage")
    public ResponseBean<IPage<UserBenefit>> getAllPage(@RequestParam(defaultValue = "1") long current,
                                                       @RequestParam(defaultValue = "10") long size,
                                                       @RequestParam(required = false) String name) {
        return new ResponseBean<>(userBenefitService.getAllUserBenefitsPage(current, size, name));
    }

    @ApiImplicitParams({@ApiImplicitParam(name = "current", value = "当前页", required = true),
            @ApiImplicitParam(name = "size", value = "每页大小", required = true),
            @ApiImplicitParam(name = "name", value = "用户真实姓名")})
    @ApiOperation(value = "获得分页收益列表2")
    @GetMapping("/getAllPageWithLegalName")
    public ResponseBean<IPage<UserBenefitVO>> getAllPageWithLegalName(@RequestParam(defaultValue = "1") long current,
                                                                      @RequestParam(defaultValue = "10") long size,
                                                                      @RequestParam(required = false) String name) {
        return new ResponseBean<>(userBenefitService.getAllUserBenefitsWithLegalNamePage(current, size, name));
    }

    @ApiOperation(value = "收益数据至钱包")
    @PostMapping("/freshUserWallet")
    public ResponseBean<String> freshUserWallet(@RequestParam(required = false) String date) {
        // 如果前端没传，默认当天；否则按传入的解析
        Date targetDate = StrUtil.isBlank(date) ? DateUtil.date() : DateUtil.parseDate(date);
        userBenefitService.pushDailyReturnToWallet(targetDate);
        return new ResponseBean<>("success");
    }

}