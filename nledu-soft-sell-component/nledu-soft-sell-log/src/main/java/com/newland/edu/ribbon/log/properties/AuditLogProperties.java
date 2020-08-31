package com.newland.edu.ribbon.log.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @author majun
 * @description 审计日志配置属性
 * @date 2020/8/31
 */
@ConfigurationProperties(prefix = "xmg.audit-log")
@RefreshScope
@Getter
@Setter
public class AuditLogProperties {

    /***
     * 是否开启审计日志，默认不开启
     */
    private Boolean enable = false;

    /***
     *日志记录类型(logger/redis/db/es)
     */
    private String logType;

}
