package com.newland.edu.ribbon.auth2.common.store;

import com.newland.edu.ribbon.auth2.common.properties.SecurityProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * 认证服务器使用Redis存取令牌 <br/>
 * 注意: 需要配置redis参数
 *
 * @author majun
 * @date 2020/6/27
 */
@ConditionalOnProperty(prefix = "xmg.oauth2.token.store", name = "type", havingValue = "redis", matchIfMissing = true)
public class AuthRedisTokenStore {
    @Bean
    public TokenStore tokenStore(RedisConnectionFactory connectionFactory, SecurityProperties securityProperties) {
        return new CustomRedisTokenStore(connectionFactory, securityProperties);
    }
}
