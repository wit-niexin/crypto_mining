package com.mining.crypto.controller;

import com.mining.crypto.response.ResponseBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api(tags = "测试模块")
@RestController
@RequestMapping("/test")
public class HelloController {

    @GetMapping("/")
    public ResponseBean<String> hello() {
        return new ResponseBean<>("Hello");
    }

    @ApiImplicitParam(name = "name", value = "姓名", required = true)
    @ApiOperation(value = "问好")
    @GetMapping("/sayHi")
    public ResponseBean<String> sayHi(@RequestParam String name) {
        return new ResponseBean<>("Hi" + name);
    }

}