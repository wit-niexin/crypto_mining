package com.mining.crypto.controller.admin;

import com.mining.crypto.response.AdminDashboard;
import com.mining.crypto.response.ResponseBean;
import com.mining.crypto.service.IMiningRigService;
import com.mining.crypto.service.IUserBenefitService;
import com.mining.crypto.service.IUserService;
import com.mining.crypto.service.IWithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "管理员看板模块")
@RestController
@RequestMapping("/dashboard")
public class A_DashboardController {

    @Autowired
    public IUserService userService;
    @Autowired
    private IMiningRigService miningRigService;
    @Autowired
    private IWithdrawalService withdrawalService;
    @Autowired
    private IUserBenefitService userBenefitService;

    @ApiOperation(value = "获得管理员统计数据")
    @GetMapping("/getAdminAllData")
    public ResponseBean<AdminDashboard> getAdminAllData() {
        Long totalUsers = userService.count();
        Long totalMiners = miningRigService.count();
        Long todayEarnings = 0L;
        Long pendingWithdrawals = 0L;
        return new ResponseBean<>(new AdminDashboard(totalUsers, totalMiners, todayEarnings, pendingWithdrawals));
    }

}