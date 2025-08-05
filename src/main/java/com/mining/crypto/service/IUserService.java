package com.mining.crypto.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mining.crypto.vo.User;
import java.util.List;

public interface IUserService extends IService<User> {

    User login(String name, String password);

    List<User> getAllUsers();

}