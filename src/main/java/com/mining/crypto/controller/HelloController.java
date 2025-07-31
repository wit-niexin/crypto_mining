package com.mining.crypto.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api(tags = "测试模块")
@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "Hello";
    }

    @ApiImplicitParam(name = "name", value = "姓名", required = true)
    @ApiOperation(value = "问好")
    @GetMapping("/sayHi")
    public ResponseEntity<String> sayHi(@RequestParam(value = "name") String name) {
        return ResponseEntity.ok("Hi:" + name);
    }
}