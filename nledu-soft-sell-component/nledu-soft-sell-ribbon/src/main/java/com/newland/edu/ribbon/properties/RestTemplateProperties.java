package com.newland.edu.ribbon.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * RestTemplate属性
 *
 * @author majun
 * @date 2020/7/29
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "xmg.rest-template")
public class RestTemplateProperties {
    /**
     * 最大链接数
     */
    private int maxTotal = 200;

    /**
     * 同路由最大并发数
     */
    private int maxPerRoute = 50;

    /**
     * 读取超时时间 ms
     */
    private int readTimeout = 35000;

    /**
     * 连接超时时间 ms
     */
    private int connectTimeout = 10000;
}
