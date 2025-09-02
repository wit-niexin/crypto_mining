package com.mining.crypto.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mining.crypto.vo.User;

public interface IUserService extends IService<User> {

    User login(String name, String password);

    IPage<User> getAllUsersPage(long current, long size, String name, Integer status);

    int getUsersCount();

    boolean addUser(User user);

    int changePassword(String name, String oldPassword, String newPassword);

    User updateUser(User user);

}