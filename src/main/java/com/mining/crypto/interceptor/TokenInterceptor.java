package com.mining.crypto.interceptor;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.mining.crypto.exception.TokenErrorException;
import com.mining.crypto.service.IJwtTokenService;
import com.mining.crypto.util.RolePermissions;
import com.mining.crypto.util.UserContext;
import com.mining.crypto.util.token.TokenState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    private IJwtTokenService jwtTokenService;

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            return true;
        }

        String token = request.getHeader("Authorization");
        if (StringUtils.isBlank(token) || !token.startsWith("Bearer ")) {
            throw new TokenErrorException("token is null");
        } else {
            token = token.substring(7);
            Map<String, String> resultMap = jwtTokenService.verifyTokenValid(token, SecureUtil.md5(jwtSecret));
            String status = resultMap.get("state");
            if (!TokenState.VALID.toString().equals(status)) {
                throw new TokenErrorException(status);
            }
            UserContext.setUsername(resultMap.get("username"));
        }
        return true;
    }

    private boolean hasPermission(String requestUri, List<String> roles) {
        for (String role : roles) {
            List<String> allowedUrls = RolePermissions.ROLE_PERMISSION_MAP.get(role);
            if (allowedUrls != null && allowedUrls.stream().anyMatch(urlPattern -> requestUri.matches(urlPattern))) {
                return true;
            }
        }
        return false;
    }
}