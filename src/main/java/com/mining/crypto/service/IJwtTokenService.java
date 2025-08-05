package com.mining.crypto.service;

import com.mining.crypto.util.token.PayloadDto;
import com.mining.crypto.vo.User;
import java.util.Map;

public interface IJwtTokenService {

    /**
     * 生成用户数据
     */
    PayloadDto getPayloadDto(User user);

    /**
     * 模拟生成用户数据
     */
    PayloadDto getDefaultPayloadDto();

    /**
     * 生成token
     */
    String generateToken(PayloadDto payload, String secret);

    /**
     * 生成token
     */
    String generateToken(User user, String secret);

    /**
     * 验证token
     */
    Map<String, String> verifyToken(String token, String secret);
}