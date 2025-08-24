package com.mining.crypto.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mining.crypto.vo.UserBenefit;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface UserBenefitMapper extends BaseMapper<UserBenefit> {

    IPage<UserBenefit> selectAllUserBenefitsPage(IPage<UserBenefit> page, @Param("user_name") String name);

    List<Map<String, Object>> sumDailyReturnByDate(@Param("modify_date") String date);

}