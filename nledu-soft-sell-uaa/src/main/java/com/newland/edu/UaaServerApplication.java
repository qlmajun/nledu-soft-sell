package com.newland.edu;

import com.newland.edu.ribbon.annotation.EnableFeignInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author majun
 * @date 2020/6/27
 */
@EnableFeignClients
@EnableFeignInterceptor
@EnableDiscoveryClient
@SpringBootApplication
public class UaaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(UaaServerApplication.class, args);
    }
}
