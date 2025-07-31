package com.mining.crypto.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mining.crypto.mapper.UserMapper;
import com.mining.crypto.service.IUserService;
import com.mining.crypto.vo.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}