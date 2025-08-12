package com.mining.crypto.controller.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mining.crypto.response.ResponseBean;
import com.mining.crypto.service.IMiningRigService;
import com.mining.crypto.vo.MiningRig;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api(tags = "矿机管理模块")
@RestController
@RequestMapping("/mining_rig")
public class A_MiningRigController {

    @Autowired
    private IMiningRigService miningRigService;

    @ApiImplicitParams({@ApiImplicitParam(name = "current", value = "当前页", required = true),
                        @ApiImplicitParam(name = "size", value = "每页大小", required = true),
                        @ApiImplicitParam(name = "name", value = "用户名"),
                        @ApiImplicitParam(name = "status", value = "状态")})
    @ApiOperation(value = "获得分页矿机列表")
    @GetMapping("/getAllPage")
    public ResponseBean<IPage<MiningRig>> getAllPage(@RequestParam(defaultValue = "1") long current,
                                                     @RequestParam(defaultValue = "10") long size,
                                                     @RequestParam(required = false) String name,
                                                     @RequestParam(required = false) Integer status) {
        return new ResponseBean<>(miningRigService.getAllMiningRigsPage(current, size, name, status));
    }

    @ApiImplicitParam(name = "miningRig", value = "矿机", required = true, dataType = "MiningRig", paramType = "body")
    @ApiOperation(value = "修改矿机状态")
    @PostMapping("/updateMiningRig")
    public ResponseBean<Boolean> updateMiningRig(@RequestBody MiningRig miningRig) {
        return new ResponseBean<>(miningRigService.updateById(miningRig));
    }

    @ApiImplicitParam(name = "miningRig", value = "新矿机", required = true, dataType = "MiningRig", paramType = "body")
    @ApiOperation(value = "新增矿机")
    @PostMapping("/addMiningRig")
    public ResponseBean<Boolean> addMiningRig(@RequestBody MiningRig miningRig) {
        miningRig.setCommonValue("admin");
        return new ResponseBean<>(miningRigService.save(miningRig));
    }

}