package com.mining.crypto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2WebMvc
public class Knife4jConfiguration {

    private ApiInfo apiInfo(String title) {
        return new ApiInfoBuilder()
                .title(title)
                .description("# Knife4j RESTful APIs")
                .termsOfServiceUrl("https://doc.xiaominfo.com/")
                .version("1.0")
                .build();
    }

    @Bean
    public Docket testApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo("测试接口"))
                .groupName("测试模块")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.mining.crypto.controller.test"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }

    @Bean
    public Docket adminApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo("管理接口"))
                .groupName("管理模块")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.mining.crypto.controller.admin"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }

    @Bean
    public Docket userApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo("用户接口"))
                .groupName("用户模块")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.mining.crypto.controller.user"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }
}