package com.mining.crypto.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mining.crypto.vo.UserDashboard;
import java.util.List;

public interface UserDashboardMapper extends BaseMapper<UserDashboard> {

    UserDashboard selectByUserNameToday(String name);

    List<UserDashboard> selectByUserName(String name);

    void insertTodayByYesterday();

}