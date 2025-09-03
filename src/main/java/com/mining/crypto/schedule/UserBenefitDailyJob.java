package com.mining.crypto.schedule;

import com.mining.crypto.service.IUserBenefitService;
import com.mining.crypto.service.IUserDashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.Date;

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
    @Scheduled(cron = "5 0 0 * * ?")
    public void run() {
        // 1、刷新每天新增的收益
        userBenefitService.incrDaysAndRefreshCumulative();
        // 2、刷新钱包的流水记录
        userBenefitService.pushDailyReturnToWallet(new Date());
        // 3、刷新用户数据统计面板
        userDashboardService.refreshAllDashboard();

    }
}