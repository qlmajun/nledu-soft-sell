package com.newland.edu.ribbon;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * Feign自动配置
 *
 * @author majun
 * @date 2020/7/29
 */
public class FeignAutoConfigure {

    /**
     * Feign 日志级别
     *
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
