package com.newland.edu.oauth.service.impl;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.code.RandomValueAuthorizationCodeServices;
import org.springframework.stereotype.Service;

/**
 * JdbcAuthorizationCodeServices替换
 * @author majun
 * @date 2020/6/27
 */
@Service
public class RedisAuthorizationCodeServices extends RandomValueAuthorizationCodeServices {
    @Override
    protected void store(String s, OAuth2Authentication oAuth2Authentication) {

    }

    @Override
    protected OAuth2Authentication remove(String s) {
        return null;
    }
}
