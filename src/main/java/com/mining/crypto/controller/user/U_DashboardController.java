package com.mining.crypto.controller.user;

import com.mining.crypto.response.ResponseBean;
import com.mining.crypto.service.IUserDashboardService;
import com.mining.crypto.vo.UserDashboard;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;

@Api(tags = "用户看板模块")
@RestController
@RequestMapping("/dashboard")
public class U_DashboardController {

    @Autowired
    public IUserDashboardService userDashboardService;

    @ApiImplicitParam(name = "name", value = "用户名", required = true)
    @ApiOperation(value = "获得用户看板数据")
    @GetMapping("/getUserDashboard")
    public ResponseBean<UserDashboard> getUserDashboard(@RequestParam String name) {
        return new ResponseBean<>(userDashboardService.getUserDashboard(name));
    }

    @ApiImplicitParam(name = "name", value = "用户名", required = true)
    @ApiOperation(value = "获得用户看板绘图")
    @GetMapping("/getUserDashboardChart")
    public ResponseBean<List<UserDashboard>> getUserDashboardChart(@RequestParam String name) {
        return new ResponseBean<>(userDashboardService.getUserDashboardChart(name));
    }
}