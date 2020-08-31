package com.newland.edu.ribbon.auth2.common.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * security 配置
 *
 * @author 小马哥
 * @date 2020/6/21
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "xmg.security")
@RefreshScope
public class SecurityProperties {

    /**
     * 认证配置属性
     */
    private AuthProperties auth = new AuthProperties();

    /**
     * 允许配置属性
     */
    private PermitProperties ignore = new PermitProperties();

    /**
     * 验证码配置属性
     */
    private ValidateCodeProperties code = new ValidateCodeProperties();
}
