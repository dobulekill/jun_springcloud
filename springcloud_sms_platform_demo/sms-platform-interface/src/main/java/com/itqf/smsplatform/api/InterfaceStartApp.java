package com.itqf.smsplatform.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * author:zouningsss
 * date:Created in 2020/3/15 11:39
 * description:
 */

@SpringBootApplication
@EnableDiscoveryClient
public class InterfaceStartApp {
    public static void main(String[] args) {
        SpringApplication.run(InterfaceStartApp.class, args);
    }
}
