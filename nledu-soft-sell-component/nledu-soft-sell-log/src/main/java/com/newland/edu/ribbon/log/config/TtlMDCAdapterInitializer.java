package com.newland.edu.ribbon.log.config;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author majun
 * @description 初始化TtlMDCAdapter实例，并替换MDC中的adapter对象
 * @date 2020/8/31
 */
public class TtlMDCAdapterInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        //加载TtlMDCAdapter实例
        //TtlMDCAdapter.getInstance();
    }
}
