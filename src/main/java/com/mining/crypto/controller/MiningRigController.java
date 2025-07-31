package com.mining.crypto.controller;

import com.mining.crypto.response.ResponseBean;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import java.util.List;

@Api(tags = "矿机管理模块")
@RestController
@RequestMapping("/mining_rig")
public class MiningRigController {

    @ApiOperation(value = "获得全部矿机列表")
    @GetMapping("/getAll")
    public ResponseBean<List> getAll() {
        return new ResponseBean<>();
    }

    @ApiImplicitParams({@ApiImplicitParam(name = "name", value = "名称", required = true), @ApiImplicitParam(name = "status", value = "状态", required = true)})
    @ApiOperation(value = "修改矿机状态")
    @GetMapping("/updateStatus")
    public ResponseBean<Boolean> updateStatus(@RequestParam(value = "name") String name, @RequestParam(value = "status") String status) {
        return new ResponseBean<>();
    }
}