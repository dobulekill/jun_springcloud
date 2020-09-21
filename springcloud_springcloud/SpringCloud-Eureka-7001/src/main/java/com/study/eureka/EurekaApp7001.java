package com.study.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @description:
 * 启动之后访问http://localhost:7001/ 可以进入控制中心
 * @author: Leo
 * @createDate: 2020/2/11
 * @version: 1.0
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaApp7001
{
    public static void main(String[] args)
    {
        SpringApplication.run(EurekaApp7001.class,args);
    }
}
