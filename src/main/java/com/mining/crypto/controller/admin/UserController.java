package com.mining.crypto.controller.admin;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mining.crypto.response.ResponseBean;
import com.mining.crypto.response.UserInfo;
import com.mining.crypto.service.IJwtTokenService;
import com.mining.crypto.service.IUserService;
import com.mining.crypto.vo.User;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@Api(tags = "用户管理模块")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IJwtTokenService jwtTokenService;

    @Value("${jwt.secret}")
    private String jwtSecret;

    @ApiOperation(value = "获得全部用户列表")
    @GetMapping("/getAll")
    public ResponseBean<List> getAll() {
        return new ResponseBean<>(userService.getAllUsers());
    }

    @ApiImplicitParams({@ApiImplicitParam(name = "current", value = "当前页", required = true),
                        @ApiImplicitParam(name = "size", value = "每页大小", required = true),
                        @ApiImplicitParam(name = "name", value = "用户名", required = false),
                        @ApiImplicitParam(name = "status", value = "状态", required = false)})
    @ApiOperation(value = "获得分页用户列表")
    @GetMapping("/getAllPage")
    public ResponseBean<IPage<User>> getAllPage(@RequestParam(defaultValue = "1") long current,
                                                @RequestParam(defaultValue = "10") long size,
                                                @RequestParam(required = false) String name,
                                                @RequestParam(required = false) Integer status) {
        return new ResponseBean<>(userService.getAllUsersPage(current, size, name, status));
    }

    @ApiImplicitParam(name = "user", value = "新用户", required = true, dataType = "User", paramType = "body")
    @ApiOperation(value = "新增用户")
    @PostMapping("/addUser")
    public ResponseBean<String> addUser(@RequestBody User user) {
        user.setCommonValue("admin");
        return new ResponseBean<>(userService.addUser(user) ? "true" : "false");
    }

    @ApiImplicitParams({@ApiImplicitParam(name = "name", value = "用户名", required = true), @ApiImplicitParam(name = "password", value = "密码", required = true)})
    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public ResponseBean<UserInfo> login(@RequestParam String name, @RequestParam String password) {
        User user = userService.login(name, password);
        String token = jwtTokenService.generateToken(user, SecureUtil.md5(jwtSecret));
        return new ResponseBean<>(new UserInfo(user, token));
    }
}