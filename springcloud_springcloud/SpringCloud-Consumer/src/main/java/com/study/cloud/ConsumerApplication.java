package com.study.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @description:
 * @author: Leo
 * @createDate: 2020/2/10
 * @version: 1.0
 */
@EnableEurekaClient
@SpringBootApplication
public class ConsumerApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(ConsumerApplication.class,args);
    }
}
