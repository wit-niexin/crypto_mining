package com.mining.crypto.controller.admin;

import com.mining.crypto.response.ResponseBean;
import com.mining.crypto.service.IWithdrawalService;
import com.mining.crypto.vo.Withdrawal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import java.util.List;

@Api(tags = "提现管理模块")
@RestController
@RequestMapping("/withdrawal")
public class WithdrawalController {

    @Autowired
    private IWithdrawalService withdrawalService;

    @ApiOperation(value = "获得全部提现申请列表")
    @GetMapping("/getAll")
    public ResponseBean<List> getAll() {
        return new ResponseBean<>(withdrawalService.list());
    }

    @ApiImplicitParam(name = "withdrawal", value = "新提现", required = true, dataType = "Withdrawal", paramType = "body")
    @ApiOperation(value = "新增提现申请")
    @PostMapping("/addWithdrawal")
    public ResponseBean<Boolean> addWithdrawal(@RequestBody Withdrawal withdrawal) {
        withdrawal.setCommonValue("admin");
        return new ResponseBean<>(withdrawalService.save(withdrawal));
    }

    @ApiImplicitParam(name = "withdrawal", value = "申请信息", required = true, dataType = "Withdrawal", paramType = "body")
    @ApiOperation(value = "更新申请状态")
    @PostMapping("/updateWithdrawal")
    public ResponseBean<Boolean> updateWithdrawal(@RequestBody Withdrawal withdrawal) {
        withdrawal.setCommonValue("admin");
        return new ResponseBean<>(withdrawalService.updateById(withdrawal));
    }

}