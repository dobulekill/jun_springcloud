package com.study.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @description:
 * 只要配置了这个注解：@EnableEurekaClient 自动就会把客户端注册到Eureka服务中
 * @author: Leo
 * @createDate: 2020/2/10
 * @version: 1.0
 */
@EnableEurekaClient
@SpringBootApplication
public class ProviderApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(ProviderApplication.class,args);
    }
}
