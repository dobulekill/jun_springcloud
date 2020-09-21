package com.itqf.smsplatporm.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * author:zouningsss
 * date:Created in 2020/3/14 23:26
 * description:
 */

@EnableEurekaServer
@SpringBootApplication
public class EurekaStartApp {
    public static void main(String[] args) {
        SpringApplication.run(EurekaStartApp.class, args);
    }
}
