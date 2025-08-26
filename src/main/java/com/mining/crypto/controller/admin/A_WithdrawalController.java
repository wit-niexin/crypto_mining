package com.mining.crypto.controller.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mining.crypto.response.ResponseBean;
import com.mining.crypto.service.IWithdrawalService;
import com.mining.crypto.vo.Withdrawal;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api(tags = "用户提现管理模块")
@RestController
@RequestMapping("/withdrawal")
public class A_WithdrawalController {

    @Autowired
    private IWithdrawalService withdrawalService;

    @ApiImplicitParams({@ApiImplicitParam(name = "current", value = "当前页", required = true),
                        @ApiImplicitParam(name = "size", value = "每页大小", required = true),
                        @ApiImplicitParam(name = "name", value = "用户名"),
                        @ApiImplicitParam(name = "status", value = "状态")})
    @ApiOperation(value = "获得分页提现列表")
    @GetMapping("/getAllPage")
    public ResponseBean<IPage<Withdrawal>> getAllPage(@RequestParam(defaultValue = "1") long current,
                                                       @RequestParam(defaultValue = "10") long size,
                                                       @RequestParam(required = false) String name,
                                                       @RequestParam(required = false) Integer status) {
        return new ResponseBean<>(withdrawalService.getAllWithdrawalsPage(current, size, name, status));
    }

    @ApiImplicitParam(name = "withdrawal", value = "申请信息", required = true, dataType = "Withdrawal", paramType = "body")
    @ApiOperation(value = "更新申请状态")
    @PostMapping("/updateWithdrawal")
    public ResponseBean<Boolean> updateWithdrawal(@RequestBody Withdrawal withdrawal) {
        return new ResponseBean<>(withdrawalService.updateStatus(withdrawal));
    }

}