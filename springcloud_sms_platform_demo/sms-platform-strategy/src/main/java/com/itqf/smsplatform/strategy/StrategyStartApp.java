package com.itqf.smsplatform.strategy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * author:zouningsss
 * date:Created in 2020/3/15 11:41
 * description:
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class StrategyStartApp {
    public static void main(String[] args) {
        SpringApplication.run(StrategyStartApp.class, args);
    }
}
