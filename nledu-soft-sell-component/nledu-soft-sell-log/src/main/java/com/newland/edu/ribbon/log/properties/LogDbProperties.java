package com.newland.edu.ribbon.log.properties;

import com.zaxxer.hikari.HikariConfig;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author majun
 * @description 日志数据源配置，logType=db时生效(非必须)，如果不配置则使用当前数据源
 * @date 2020/8/31
 */
@ConfigurationProperties(prefix = "xmg.audit-log.datasource")
@Getter
@Setter
public class LogDbProperties extends HikariConfig {

}
