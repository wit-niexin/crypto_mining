package com.mining.crypto.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mining.crypto.exception.LoginErrorException;
import com.mining.crypto.mapper.UserMapper;
import com.mining.crypto.service.IUserService;
import com.mining.crypto.vo.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public User login(String name, String password) {
        User user = baseMapper.selectUserByName(name);
        if (user.getStatus() == 1) {
            throw new LoginErrorException("该用户已被禁用");
        } else if (!password.equals(user.getPassword())) {
            throw new LoginErrorException("用户名或者密码错误");
        } else {
            return user;
        }
    }

    @Override
    @Cacheable(value = "users", key = "'allUsers'")
    public List<User> getAllUsers() {
        return baseMapper.selectAllUsers();
    }
}