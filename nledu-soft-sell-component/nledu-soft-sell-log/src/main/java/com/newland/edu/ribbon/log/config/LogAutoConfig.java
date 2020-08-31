package com.newland.edu.ribbon.log.config;

import com.newland.edu.ribbon.log.properties.AuditLogProperties;
import com.newland.edu.ribbon.log.properties.LogDbProperties;
import com.newland.edu.ribbon.log.properties.TraceProperties;
import com.zaxxer.hikari.HikariConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author majun
 * @description 日志自动配置
 * @date 2020/8/31
 */
@EnableConfigurationProperties({AuditLogProperties.class, TraceProperties.class})
public class LogAutoConfig {

    /**
     * 日志数据库配置
     */
    @Configuration
    @ConditionalOnClass(HikariConfig.class)
    @EnableConfigurationProperties(LogDbProperties.class)
    public static class LogDbAutoConfigure {

    }
}
