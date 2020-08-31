package com.newland.edu.ribbon.auth2.common.config;

import com.newland.edu.ribbon.auth2.common.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.expression.OAuth2WebSecurityExpressionHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.annotation.Resource;

/**
 * 默认资源服务器配置
 *
 * @author 小马哥
 * @date 2020/6/21
 */
@Import(DefaultSecurityHandlerConfig.class)
public class DefaultResourceServerConfig extends ResourceServerConfigurerAdapter {

    /**
     * 用户token存储
     */
    @Autowired
    private TokenStore tokenStore;

    /**
     * 用来解决匿名用户访问无权限资源时的异常
     */
    @Resource
    private AuthenticationEntryPoint authenticationEntryPoint;

    /**
     * oauth2 web安全表达式处理
     */
    @Resource
    private OAuth2WebSecurityExpressionHandler expressionHandler;

    /**
     * oauth2 权限拒绝处理
     */
    @Resource
    private OAuth2AccessDeniedHandler oAuth2AccessDeniedHandler;

    /***
     * 安全配置属性
     */
    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(tokenStore) //指定token存储方式
                //设置允许使用token
                .stateless(true)
                .authenticationEntryPoint(authenticationEntryPoint)
                .expressionHandler(expressionHandler)
                .accessDeniedHandler(oAuth2AccessDeniedHandler);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.AuthorizedUrl authorizedUrl = setHttp(http)
                .authorizeRequests()
                .antMatchers(securityProperties.getIgnore().getUrls()).permitAll()
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .anyRequest();
        setAuthenticate(authorizedUrl);

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .and()
                .httpBasic().disable()
                .headers()
                .frameOptions().disable()
                .and()
                .csrf().disable();
    }

    /**
     * url权限控制，默认是认证就通过，可以重写实现个性化
     *
     * @param authorizedUrl
     */
    public HttpSecurity setAuthenticate(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.AuthorizedUrl authorizedUrl) {
        return authorizedUrl.authenticated().and();
    }

    /**
     * 留给子类重写扩展功能
     *
     * @param http
     */
    public HttpSecurity setHttp(HttpSecurity http) {
        return http;
    }
}
