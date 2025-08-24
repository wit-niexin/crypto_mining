package com.mining.crypto.schedule;

import com.mining.crypto.service.IUserBenefitService;
import com.mining.crypto.service.IUserDashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * 每日凌晨 1 点刷新用户数据
 */
@Component
public class UserBenefitDailyJob {

    @Autowired
    public IUserBenefitService userBenefitService;
    @Autowired
    public IUserDashboardService userDashboardService;

    /**
     * 每天 01:00:00 执行
     * 秒 分 时 日 月 星期
     */
    @Scheduled(cron = "0 0 1 * * ?")
    public void run() {
        userBenefitService.incrDaysAndRefreshCumulative();
        userBenefitService.pushDailyReturnToWallet(LocalDate.now());
        userDashboardService.refreshAllDashboard();

    }
}