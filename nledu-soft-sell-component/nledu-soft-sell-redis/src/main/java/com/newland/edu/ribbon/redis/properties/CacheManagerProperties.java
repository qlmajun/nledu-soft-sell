package com.newland.edu.ribbon.redis.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/***
 * 缓存管理属性
 * @author 小马哥
 * @date 2020/06/19
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "xmg.cache-manager")
public class CacheManagerProperties {

    private List<CacheConfig> configs;

    @Setter
    @Getter
    public static class CacheConfig {
        /**
         * cache key
         */
        private String key;
        /**
         * 过期时间，sec
         */
        private long second = 60;
    }
}
