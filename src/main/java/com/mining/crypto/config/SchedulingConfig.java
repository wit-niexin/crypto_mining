package com.mining.crypto.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@ConditionalOnProperty(
        prefix = "schedule",
        name   = "enabled",
        havingValue = "true",
        matchIfMissing = true)   // 默认开启
public class SchedulingConfig {

}