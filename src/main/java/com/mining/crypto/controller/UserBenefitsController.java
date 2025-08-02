package com.mining.crypto.controller;

import com.mining.crypto.service.IUserBenefitsService;
import com.mining.crypto.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api(tags = "用户收益管理模块")
@RestController
@RequestMapping("/user_benefits")
public class UserBenefitsController {

    @Autowired
    private IUserBenefitsService userBenefitsService;

    @ApiImplicitParam(name = "user", value = "新用户", required = true, dataType = "User", paramType = "body")
    @ApiOperation(value = "用户注册")
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        user.setCommonValue("admin");
        return ResponseEntity.ok(userService.save(user) ? "true" : "false");
    }
}