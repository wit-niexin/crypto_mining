package com.mining.crypto.controller.admin;

import com.mining.crypto.response.AdminDashboard;
import com.mining.crypto.response.ResponseBean;
import com.mining.crypto.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Date;

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
    private IUserWalletService userWalletService;

    @ApiOperation(value = "获得管理员统计数据")
    @GetMapping("/getAdminAllData")
    public ResponseBean<AdminDashboard> getAdminAllData() {
        Date date = new Date();
        int totalUsers = userService.getUsersCount();
        int totalMiners = miningRigService.getMiningRigsCount();
        double todayEarnings = userWalletService.sumInMoneyByDate(date, date);
        int pendingWithdrawals = withdrawalService.countWaitingApprovals();
        return new ResponseBean<>(new AdminDashboard(totalUsers, totalMiners, todayEarnings, pendingWithdrawals));
    }

}