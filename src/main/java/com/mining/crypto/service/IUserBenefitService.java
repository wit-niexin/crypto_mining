package com.mining.crypto.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mining.crypto.vo.UserBenefit;

public interface IUserBenefitService extends IService<UserBenefit> {

    IPage<UserBenefit> getAllUserBenefitsPage(long current, long size, String name);

}