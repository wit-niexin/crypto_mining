package com.mining.crypto.controller.user;

import cn.hutool.crypto.SecureUtil;
import com.mining.crypto.annotation.Decrypt;
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

@Api(tags = "个人用户模块")
@RestController
@RequestMapping("/user")
public class U_UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IJwtTokenService jwtTokenService;

    @Value("${jwt.secret}")
    private String jwtSecret;

    @ApiImplicitParams({@ApiImplicitParam(name = "name", value = "用户名", required = true), @ApiImplicitParam(name = "password", value = "密码", required = true)})
    @ApiOperation(value = "用户登录")
    @GetMapping("/login")
    public ResponseBean<UserInfo> login(@RequestParam String name, @Decrypt String password) {
        User user = userService.login(name, password);
        String token = jwtTokenService.generateToken(user, SecureUtil.md5(jwtSecret));
        return new ResponseBean<>(new UserInfo(user, token));
    }

    @ApiImplicitParam(name = "user", value = "用户", required = true, dataType = "User", paramType = "body")
    @ApiOperation(value = "修改用户")
    @PostMapping("/updateUser")
    public ResponseBean<String> updateUser(@RequestBody User user) {
        user.setCommonValue("admin");
        return new ResponseBean<>(userService.updateUser(user) ? "true" : "false");
    }
}