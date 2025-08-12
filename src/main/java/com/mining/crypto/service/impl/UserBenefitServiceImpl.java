package com.mining.crypto.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mining.crypto.mapper.UserBenefitMapper;
import com.mining.crypto.service.IUserBenefitService;
import com.mining.crypto.vo.UserBenefit;
import org.springframework.stereotype.Service;

@Service
public class UserBenefitServiceImpl extends ServiceImpl<UserBenefitMapper, UserBenefit> implements IUserBenefitService {

    @Override
    public IPage<UserBenefit> getAllUserBenefitsPage(long current, long size, String name, Integer status) {
        return baseMapper.selectAllUserBenefitsPage(new Page<>(current, size), name, status);
    }
}