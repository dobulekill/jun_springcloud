package com.study.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @description:
 * @author: Leo
 * @createDate: 2020/2/10
 * @version: 1.0
 */
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients(basePackages = "com.study.cloud")
public class FeignApp
{
    public static void main(String[] args)
    {
        SpringApplication.run(FeignApp.class,args);
    }
}
