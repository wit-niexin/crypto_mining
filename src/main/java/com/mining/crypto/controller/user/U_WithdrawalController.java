package com.mining.crypto.controller.user;

import com.mining.crypto.response.ResponseBean;
import com.mining.crypto.service.IWithdrawalService;
import com.mining.crypto.vo.Withdrawal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api(tags = "个人提现模块")
@RestController
@RequestMapping("/withdrawal")
public class U_WithdrawalController {

    @Autowired
    private IWithdrawalService withdrawalService;

    @ApiImplicitParam(name = "withdrawal", value = "新提现", required = true, dataType = "Withdrawal", paramType = "body")
    @ApiOperation(value = "新增提现申请")
    @PostMapping("/addWithdrawal")
    public ResponseBean<Boolean> addWithdrawal(@RequestBody Withdrawal withdrawal) {
        withdrawal.setCommonValue("admin");
        return new ResponseBean<>(withdrawalService.save(withdrawal));
    }

    @ApiImplicitParam(name = "withdrawal", value = "提现申请", required = true, dataType = "Withdrawal", paramType = "body")
    @ApiOperation(value = "删除提现申请")
    @PostMapping("/delWithdrawal")
    public ResponseBean<Boolean> delWithdrawal(@RequestBody Withdrawal withdrawal) {
        withdrawal.setCommonValue("admin");
        return new ResponseBean<>(withdrawalService.removeById(withdrawal));
    }

}