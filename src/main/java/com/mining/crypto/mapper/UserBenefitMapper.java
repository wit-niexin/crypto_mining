package com.mining.crypto.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mining.crypto.vo.UserBenefit;

public interface UserBenefitMapper extends BaseMapper<UserBenefit> {

    IPage<UserBenefit> selectAllUserBenefitsPage(IPage<UserBenefit> page, String name, Integer status);

}