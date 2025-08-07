package com.mining.crypto.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mining.crypto.vo.User;
import io.lettuce.core.dynamic.annotation.Param;
import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    User selectUserByName(String name);

    List<User> selectAllUsers();

    IPage<User> selectAllUsersPage(IPage<User> page, @Param("name") String name, @Param("status") Integer status);

}