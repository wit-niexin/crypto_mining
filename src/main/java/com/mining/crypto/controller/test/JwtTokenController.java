package com.mining.crypto.controller.test;

import java.util.Map;
import com.mining.crypto.response.ResponseBean;
import com.mining.crypto.service.IJwtTokenService;
import com.mining.crypto.util.token.PayloadDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import cn.hutool.crypto.SecureUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Token测试模块")
@RestController
@RequestMapping("/token")
public class JwtTokenController {

    @Autowired
    private IJwtTokenService jwtTokenService;

    @Value("${jwt.secret}")
    private String jwtSecret;
    
    @ApiOperation(value = "生成token")
    @GetMapping("/generateToken")
    public ResponseBean<String> generateToken(){
        PayloadDto payload = jwtTokenService.getDefaultPayloadDto();
        String token = jwtTokenService.generateToken(payload, SecureUtil.md5(jwtSecret));
        return new ResponseBean<>(token);
    }

    @ApiOperation("验证token")
    @GetMapping(value = "/verifyToken")
    public ResponseBean<String> verifyToken(@RequestParam String token) {
        Map<String, String> resultMap = jwtTokenService.verifyToken(token, SecureUtil.md5(jwtSecret));
        return new ResponseBean<>(resultMap.get("state"));
    }
}