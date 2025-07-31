package com.mining.crypto.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.mining.crypto.mapper")
public class MybatisPlusConfig {

}