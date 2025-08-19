package com.mining.crypto.config;

import com.mining.crypto.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private TokenInterceptor tokenInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截指定路径及其下属路径
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/withdrawal/**")      // 拦截 /withdrawal 及其所有子路径
                .addPathPatterns("/user_benefit/**")    // 拦截 /user_benefit 及其所有子路径
                .addPathPatterns("/mining_rig/**")      // 拦截 /mining_rig 及其所有子路径
                .addPathPatterns("/user/**")            // 拦截 /user 及其所有子路径
                .excludePathPatterns("/user/login/**"); // 如果需要排除某些子路径
    }
}