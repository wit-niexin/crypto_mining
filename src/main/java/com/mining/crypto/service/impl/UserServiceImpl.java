package com.mining.crypto.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mining.crypto.exception.LoginErrorException;
import com.mining.crypto.exception.SaveErrorException;
import com.mining.crypto.mapper.UserMapper;
import com.mining.crypto.mapper.UserRoleMapper;
import com.mining.crypto.service.IUserService;
import com.mining.crypto.vo.Role;
import com.mining.crypto.vo.User;
import com.mining.crypto.vo.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public User login(String name, String password) {
        User user = baseMapper.selectUserByName(name);
        if (user == null) {
            throw new LoginErrorException("该用户不存在");
        } else if (user.getStatus() == 1) {
            throw new LoginErrorException("该用户已被禁用");
        } else if (!password.equals(user.getPassword())) {
            throw new LoginErrorException("用户名或者密码错误");
        } else {
            return user;
        }
    }

    @Override
    public IPage<User> getAllUsersPage(long current, long size, String name, Integer status) {
        return baseMapper.selectAllUsersPage(new Page<>(current, size), name, status);
    }

    @Override
    public boolean addUser(User user) {
        if (baseMapper.insert(user) != 1) {
            throw new SaveErrorException("用户保存失败");
        }

        List<Role> roles = user.getRoles();
        if (CollectionUtils.isNotEmpty(roles)) {
            List<UserRole> list = roles.stream()
                    .map(role -> {
                        UserRole userRole = new UserRole(user.getId(), role.getId());
                        userRole.setCommonValue("admin");
                        return userRole;
                    })
                    .collect(Collectors.toList());
            if (userRoleMapper.insert(list).size() != list.size()) {
                throw new SaveErrorException("用户角色保存失败");
            }
        }
        return true;
    }

    @Override
    public boolean updateUser(User user) {
        return baseMapper.updateById(user) > 0;
    }

    @Override
    public boolean deleteUser(Long id) {
        return baseMapper.deleteById(id) > 0;
    }

}