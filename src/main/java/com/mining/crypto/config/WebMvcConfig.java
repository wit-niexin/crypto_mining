package com.mining.crypto.config;

import com.mining.crypto.interceptor.TokenInterceptor;
import com.mining.crypto.resolver.DecryptArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.util.List;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private TokenInterceptor tokenInterceptor;

    @Bean
    public DecryptArgumentResolver decryptArgumentResolver() {
        return new DecryptArgumentResolver();
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(decryptArgumentResolver());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截指定路径及其下属路径
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/dashboard/**")       // 拦截 /dashboard 及其所有子路径
                .addPathPatterns("/withdrawal/**")      // 拦截 /withdrawal 及其所有子路径
                .addPathPatterns("/user_benefit/**")    // 拦截 /user_benefit 及其所有子路径
                .addPathPatterns("/mining_rig/**")      // 拦截 /mining_rig 及其所有子路径
                .addPathPatterns("/user/**")            // 拦截 /user 及其所有子路径
                .excludePathPatterns("/user/login/**"); // 如果需要排除某些子路径
    }
}