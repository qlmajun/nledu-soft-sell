package com.newland.edu.ribbon;

import com.newland.edu.common.constant.ConfigConstants;
import com.newland.edu.ribbon.config.RuleConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

/**
 * 自定义负载均衡配置
 * @author majun
 * @date 2020/7/29
 */
@ConditionalOnProperty(value = ConfigConstants.CONFIG_RIBBON_ISOLATION_ENABLED, havingValue = "true")
@RibbonClients(defaultConfiguration = {RuleConfig.class})
public class LbIsolationAutoConfigure {
}
