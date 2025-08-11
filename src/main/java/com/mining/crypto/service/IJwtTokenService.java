package com.mining.crypto.service;

import com.mining.crypto.util.token.PayloadDto;
import com.mining.crypto.vo.User;
import java.util.Map;

public interface IJwtTokenService {

    /**
     * 在生成token之前，构造用户数据
     */
    PayloadDto getPayloadDto(User user);

    /**
     * 构造模拟用户数据
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
     * 验证token，返回验证结果
     */
    Map<String, String> verifyTokenValid(String token, String secret);

    /**
     * 验证token，返回用户数据
     */
    PayloadDto verifyTokenData(String token, String secret);
}