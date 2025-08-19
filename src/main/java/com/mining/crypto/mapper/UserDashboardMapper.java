package com.mining.crypto.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mining.crypto.vo.UserDashboard;
import org.apache.ibatis.annotations.Param;

public interface UserDashboardMapper extends BaseMapper<UserDashboard> {

    UserDashboard selectByUserName(@Param("user_name") String name);

}