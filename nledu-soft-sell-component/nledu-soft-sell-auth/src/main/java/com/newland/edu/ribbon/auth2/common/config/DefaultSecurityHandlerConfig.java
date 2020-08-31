package com.newland.edu.ribbon.auth2.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.newland.edu.common.utils.ResponseUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.expression.OAuth2WebSecurityExpressionHandler;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 默认security处理器配置
 *
 * @author 小马哥
 * @date 2020/6/21
 */
public class DefaultSecurityHandlerConfig {

    @Resource
    private ObjectMapper objectMapper;

    /**
     * 未登录，返回401
     *
     * @return
     */
    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return (request, response, authException) -> ResponseUtil.responseUnAuthorized(objectMapper, response, authException.getMessage());
    }

    /**
     * oauth2 web安全表达式处理
     *
     * @param applicationContext
     * @return
     */
    @Bean
    public OAuth2WebSecurityExpressionHandler oAuth2WebSecurityExpressionHandler(ApplicationContext applicationContext) {
        OAuth2WebSecurityExpressionHandler expressionHandler = new OAuth2WebSecurityExpressionHandler();
        expressionHandler.setApplicationContext(applicationContext);
        return expressionHandler;
    }


    /**
     * 权限拒绝处理
     *
     * @return
     */
    @Bean
    public OAuth2AccessDeniedHandler oAuth2AccessDeniedHandler() {
        return new OAuth2AccessDeniedHandler() {
            @Override
            public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException authException) throws IOException {
                ResponseUtil.responseUnAccessed(objectMapper, response, authException.getMessage());
            }
        };
    }
}
