package com.itqf.smsplatform.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * author:zouningsss
 * date:Created in 2020/3/15 11:26
 * description:
 */

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
public class CacheStartApp {
    public static void main(String[] args) {
        SpringApplication.run(CacheStartApp.class, args);
    }
}
