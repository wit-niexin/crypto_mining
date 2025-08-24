package com.mining.crypto.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mining.crypto.vo.UserBenefit;
import java.time.LocalDate;

public interface IUserBenefitService extends IService<UserBenefit> {

    IPage<UserBenefit> getAllUserBenefitsPage(long current, long size, String name);

    void incrDaysAndRefreshCumulative();

    void pushDailyReturnToWallet(LocalDate localDate);

}