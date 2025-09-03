package com.mining.crypto.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mining.crypto.mapper.UserDashboardMapper;
import com.mining.crypto.service.IUserDashboardService;
import com.mining.crypto.vo.UserDashboard;
import org.springframework.stereotype.Service;

@Service
public class UserDashboardImpl extends ServiceImpl<UserDashboardMapper, UserDashboard> implements IUserDashboardService {

    @Override
    public UserDashboard getUserDashboard(String name) {
        return baseMapper.selectByUserName(name);
    }

    public void refreshAllDashboard() {
        baseMapper.insertTodayByYesterday();
    }

}