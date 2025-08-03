package com.mining.crypto.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mining.crypto.mapper.UserBenefitsMapper;
import com.mining.crypto.service.IUserBenefitsService;
import com.mining.crypto.vo.UserBenefits;
import org.springframework.stereotype.Service;

@Service
public class UserBenefitsServiceImpl extends ServiceImpl<UserBenefitsMapper, UserBenefits> implements IUserBenefitsService {

}