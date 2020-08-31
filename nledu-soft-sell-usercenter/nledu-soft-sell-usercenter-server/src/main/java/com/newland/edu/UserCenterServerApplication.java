package com.newland.edu;

import com.newland.edu.ribbon.annotation.EnableFeignInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 用户中心服务启动类
 *
 * @author majun
 * @date 2020/7/27
 */
@EnableDiscoveryClient
@EnableFeignClients
@EnableFeignInterceptor
@SpringBootApplication
public class UserCenterServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserCenterServerApplication.class, args);
    }
}
