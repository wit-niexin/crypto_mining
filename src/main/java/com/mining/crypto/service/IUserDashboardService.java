package com.mining.crypto.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mining.crypto.vo.UserDashboard;

public interface IUserDashboardService extends IService<UserDashboard> {

    UserDashboard getUserDashboard(String name);

}