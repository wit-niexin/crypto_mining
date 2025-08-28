package com.mining.crypto.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mining.crypto.response.UserBenefitVO;
import com.mining.crypto.vo.UserBenefit;
import java.util.List;
import java.util.Map;

public interface UserBenefitMapper extends BaseMapper<UserBenefit> {

    IPage<UserBenefit> selectAllUserBenefitsPage(IPage<UserBenefit> page, String name);

    IPage<UserBenefitVO> selectAllUserBenefitsWithLegalNamePage(IPage<UserBenefit> page, String name);

    List<Map<String, Object>> sumDailyReturnByDate(String date);

}