package com.mining.crypto.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mining.crypto.response.UserBenefitVO;
import com.mining.crypto.vo.UserBenefit;
import java.util.Date;

public interface IUserBenefitService extends IService<UserBenefit> {

    IPage<UserBenefit> getAllUserBenefitsPage(long current, long size, String name);

    IPage<UserBenefitVO> getAllUserBenefitsWithLegalNamePage(long current, long size, String name);

    void incrDaysAndRefreshCumulative();

    void pushDailyReturnToWallet(Date date);

}