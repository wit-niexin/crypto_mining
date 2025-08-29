package com.mining.crypto.resolver;

import com.mining.crypto.annotation.Decrypt;
import com.mining.crypto.util.AESUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Slf4j
public class DecryptArgumentResolver implements HandlerMethodArgumentResolver {

    @Value("${aes.key}")
    private String aesKey;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(Decrypt.class) && parameter.getParameterType() == String.class;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        Decrypt anno = parameter.getParameterAnnotation(Decrypt.class);
        String field = anno.value();
        String cipherText = webRequest.getParameter(field);
        if (!StringUtils.hasText(cipherText)) {
            return null;
        }
        // 解密
        try {
            return AESUtil.decrypt(cipherText, aesKey);
        } catch (Exception e) {
            throw new IllegalArgumentException("密码解密失败", e);
        }
    }
}