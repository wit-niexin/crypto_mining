package com.mining.crypto.controller.user;

import com.mining.crypto.response.ResponseBean;
import com.mining.crypto.response.UserDashboard;
import com.mining.crypto.service.IMiningRigService;
import com.mining.crypto.service.IUserBenefitService;
import com.mining.crypto.service.IUserService;
import com.mining.crypto.service.IWithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "用户看板模块")
@RestController
@RequestMapping("/dashboard")
public class U_DashboardController {

    @Autowired
    public IUserService userService;
    @Autowired
    private IMiningRigService miningRigService;
    @Autowired
    private IWithdrawalService withdrawalService;
    @Autowired
    private IUserBenefitService userBenefitService;

    @ApiOperation(value = "获得用户统计数据")
    @GetMapping("/getUserAllData")
    public ResponseBean<UserDashboard> getUserAllData() {
        Long totalProfit = 15196L;
        Long todayProfit = 120L;
        Double annualizedReturn = 70.3;
        Long walletBalance = 2000L;
        return new ResponseBean<>(new UserDashboard(totalProfit, todayProfit, annualizedReturn, walletBalance));
    }

}