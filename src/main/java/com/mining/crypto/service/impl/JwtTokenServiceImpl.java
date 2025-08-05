package com.mining.crypto.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import com.mining.crypto.service.IJwtTokenService;
import com.mining.crypto.util.token.JWT;
import com.mining.crypto.util.token.PayloadDto;
import com.mining.crypto.util.token.TokenState;
import com.mining.crypto.vo.User;
import com.mining.crypto.vo.Role;
import org.springframework.stereotype.Service;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;

@Service
public class JwtTokenServiceImpl implements IJwtTokenService {

    /**
     * 生成token
     */
    public String generateToken(PayloadDto payloadDto, String secret) {
        String tokenString = JWT.generateTokenByHMAC(JSONUtil.toJsonStr(payloadDto), secret);
        return tokenString;
    }

    public String generateToken(User user, String secret) {
        return generateToken(getPayloadDto(user), secret);
    }

    /**
     * 模拟生成用户数据
     */
    public PayloadDto getDefaultPayloadDto() {
        Date now = new Date();
        Date exp = DateUtil.offsetSecond(now, 60 * 60);
        return PayloadDto.builder()
                .sub("default jwt")
                .iat(now.getTime())
                .exp(exp.getTime())
                .jti(UUID.randomUUID().toString())
                .username("admin")
                .authorities(CollUtil.toList("ADMIN"))
                .build();
    }

    public PayloadDto getPayloadDto(User user) {
        Date now = new Date();
        Date exp = DateUtil.offsetSecond(now, 60 * 60);
        return PayloadDto.builder()
                .sub("default jwt")
                .iat(now.getTime())
                .exp(exp.getTime())
                .jti(UUID.randomUUID().toString())
                .username(user.getName())
                .authorities(user.getRoles().stream().map(Role::getName).collect(Collectors.toList()))
                .build();
    }

    /**
     * 验证token
     */
    public Map<String, String> verifyToken(String token, String secret) {
        Map<String, String> resultMap = new HashMap<String, String>();
        String payload = JWT.verifyTokenByHMAC(token, secret);
        if (payload == null) {
            resultMap.put("state", TokenState.ERROR.toString());
        } else {
            PayloadDto payloadDto = JSONUtil.toBean(payload, PayloadDto.class);
            if (!"default jwt".equals(payloadDto.getSub())) {
                resultMap.put("state", TokenState.INVALID.toString());
            } else if (payloadDto.getExp() < new Date().getTime()) {
                resultMap.put("state", TokenState.EXPIRED.toString());
            } else {
                resultMap.put("state", TokenState.VALID.toString());
            }
        }
        return resultMap;
    }
}