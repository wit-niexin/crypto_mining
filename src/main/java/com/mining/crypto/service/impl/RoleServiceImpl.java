package com.mining.crypto.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mining.crypto.mapper.RoleMapper;
import com.mining.crypto.service.IRoleService;
import com.mining.crypto.vo.Role;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}