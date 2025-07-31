package com.mining.crypto.service;

import com.mining.crypto.util.token.PayloadDto;
import java.util.Map;

public interface IJwtTokenService {

    /**
     * 生成token
     */
    String generateToken(PayloadDto payload, String secret);

    /**
     * 模拟生成用户数据
     */
    PayloadDto getDefaultPayloadDto();

    /**
     * 验证token
     */
    Map<String, String> verifyToken(String token, String secret);
}