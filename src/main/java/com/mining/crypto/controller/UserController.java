package com.mining.crypto.controller;

import com.mining.crypto.response.ResponseBean;
import com.mining.crypto.service.IUserService;
import com.mining.crypto.vo.User;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
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

    @ApiOperation(value = "获得全部用户列表")
    @GetMapping("/getAll")
    public ResponseBean<List> getAll() {
        return new ResponseBean<>(userService.list());
    }

    @ApiImplicitParam(name = "user", value = "新用户", required = true, dataType = "User", paramType = "body")
    @ApiOperation(value = "用户注册")
    @PostMapping("/register")
    public ResponseBean<String> register(@RequestBody User user) {
        user.setCommonValue("admin");
        return new ResponseBean<>(userService.save(user) ? "true" : "false");
    }

    @ApiImplicitParams({@ApiImplicitParam(name = "name", value = "用户名", required = true), @ApiImplicitParam(name = "password", value = "密码", required = true)})
    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public ResponseBean<User> login(@RequestParam String name, @RequestParam String password) {




        return new ResponseBean<>(userService.login(name, password));
    }
}