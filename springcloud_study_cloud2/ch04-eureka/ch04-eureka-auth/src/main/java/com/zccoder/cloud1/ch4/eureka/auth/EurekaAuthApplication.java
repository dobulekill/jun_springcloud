package com.zccoder.cloud1.ch4.eureka.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 项目启动类
 * @author Wujun
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaAuthApplication extends SpringBootServletInitializer
{
    public static void main( String[] args )
    {
        SpringApplication.run(EurekaAuthApplication.class, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(EurekaAuthApplication.class);
    }
}