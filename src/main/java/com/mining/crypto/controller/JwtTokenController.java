package com.mining.crypto.controller;

import java.util.Map;
import com.mining.crypto.service.IJwtTokenService;
import com.mining.crypto.util.token.PayloadDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.hutool.crypto.SecureUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Token测试模块")
@RestController
public class JwtTokenController {

    @Autowired
    private IJwtTokenService jwtTokenService;
    
    //@ApiImplicitParam(name = "name",value = "姓名",required = true)
    @ApiOperation(value = "生成token")
    @GetMapping("/generateToken")
    public ResponseEntity<String> generateToken(){
        PayloadDto payload = jwtTokenService.getDefaultPayloadDto();
        String token = jwtTokenService.generateToken(payload, SecureUtil.md5("test"));
        return ResponseEntity.ok(token);
    }

    @ApiOperation("验证token")
    @GetMapping(value = "/verifyToken")
    public ResponseEntity<String> verifyToken(String token) {
        Map<String, String> resultMap = jwtTokenService.verifyToken(token, SecureUtil.md5("test"));
        return ResponseEntity.ok(resultMap.get("state"));
    }
}