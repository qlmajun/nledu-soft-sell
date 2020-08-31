package com.newland.edu.common.config;

import com.newland.edu.common.feign.UserServiceApi;
import com.newland.edu.common.resolver.ClientArgumentResolver;
import com.newland.edu.common.resolver.TokenArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * 默认SpringMVC拦截配置
 * @author majun
 * @description
 * @date 2020/8/31
 */
public class DefaultWebMvcConfig implements WebMvcConfigurer {

    @Lazy
    @Autowired
    private UserServiceApi userServiceApi;

    /***
     * Token 参数解析
     * @param resolvers 解析类
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        //注入用户信息
        resolvers.add(new TokenArgumentResolver(userServiceApi));
        //注入应用信息
        resolvers.add(new ClientArgumentResolver());
    }
}
