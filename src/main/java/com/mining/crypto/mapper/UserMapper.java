package com.mining.crypto.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mining.crypto.vo.User;

public interface UserMapper extends BaseMapper<User> {

    int countUsersNotAdmin();

    User selectUserByName(String name);

    IPage<User> selectAllUsersPage(IPage<User> page, String name, Integer status);

}