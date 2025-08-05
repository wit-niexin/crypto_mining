package com.mining.crypto.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mining.crypto.vo.User;
import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    User selectUserByName(String name);

    List<User> selectAllUsers();

}