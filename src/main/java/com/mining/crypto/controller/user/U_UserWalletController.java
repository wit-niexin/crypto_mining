package com.mining.crypto.controller.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mining.crypto.response.ResponseBean;
import com.mining.crypto.service.IUserWalletService;
import com.mining.crypto.vo.UserWallet;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api(tags = "个人钱包模块")
@RestController
@RequestMapping("/wallet")
public class U_UserWalletController {

    @Autowired
    private IUserWalletService userWalletService;

    @ApiImplicitParams({@ApiImplicitParam(name = "current", value = "当前页", required = true),
                        @ApiImplicitParam(name = "size", value = "每页大小", required = true),
                        @ApiImplicitParam(name = "name", value = "用户名", required = true)})
    @ApiOperation(value = "查看用户钱包")
    @GetMapping("/getUserWallet")
    public ResponseBean<IPage<UserWallet>> getUserWallet(@RequestParam(defaultValue = "1") long current,
                                                         @RequestParam(defaultValue = "10") long size,
                                                         @RequestParam String name,
                                                         @RequestParam String status) {
        return new ResponseBean<>(userWalletService.getUserWallet(current, size, name, status));
    }

    @ApiImplicitParam(name = "userWallet", value = "钱包余额变动", required = true, dataType = "UserWallet", paramType = "body")
    @ApiOperation(value = "新增钱包数据")
    @PostMapping("/addUserWallet")
    public ResponseBean<String> addUserWallet(@RequestBody UserWallet userWallet) {
        userWallet.setCommonValue("admin");
        return new ResponseBean<>(userWalletService.save(userWallet) ? "true" : "false");
    }

}