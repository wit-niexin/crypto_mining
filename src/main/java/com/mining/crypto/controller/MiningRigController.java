package com.mining.crypto.controller;

import com.mining.crypto.response.ResponseBean;
import com.mining.crypto.service.IMiningRigService;
import com.mining.crypto.vo.MiningRig;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import java.util.List;

@Api(tags = "矿机管理模块")
@RestController
@RequestMapping("/mining_rig")
public class MiningRigController {
    @Autowired
    private IMiningRigService miningRigService;

    @ApiOperation(value = "获得全部矿机列表")
    @GetMapping("/getAll")
    public ResponseBean<List<MiningRig>> getAll() {
        List<MiningRig> miningTables = miningRigService.list();
        return new ResponseBean<>(ResponseBean.SUCCESS, miningTables, "success");
    }

    @ApiImplicitParams({@ApiImplicitParam(name = "name", value = "名称", required = true), @ApiImplicitParam(name = "status", value = "状态", required = true)})
    @ApiOperation(value = "修改矿机状态")
    @PostMapping("/updateStatus")
    public ResponseBean<Boolean> updateStatus(@RequestParam(value = "name") String name, @RequestParam(value = "status") String status) {

        boolean result = miningRigService.updateStatusByName(name, status);
        if (result) {
            return new ResponseBean<>(ResponseBean.SUCCESS, true, "矿机状态修改成功");
        } else {
            return new ResponseBean<>(ResponseBean.FAIL, false, "矿机状态修改失败");
        }
    }
    @ApiImplicitParam(name = "miningRig", value = "新矿机", required = true, dataType = "MiningRig", paramType = "body")
    @ApiOperation(value = "新增矿机")
    @PostMapping("/addMiningRig")
    public ResponseBean<Boolean> addMiningRig(@RequestBody MiningRig miningRig) {
        miningRig.setCommonValue("admin");
        boolean result = miningRigService.save(miningRig);
        if (result) {
            return new ResponseBean<>(ResponseBean.SUCCESS, true, "矿机添加成功");
        } else {
            return new ResponseBean<>(ResponseBean.FAIL, false, "矿机添加失败");
        }
    }

}