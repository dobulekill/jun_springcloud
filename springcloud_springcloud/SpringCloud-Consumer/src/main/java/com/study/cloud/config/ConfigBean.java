package com.study.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author: Leo
 * @createDate: 2020/2/10
 * @version: 1.0
 */
@Configuration //这是springboot中的注解，他的作用相当于spring中的applicationContext.xml
public class ConfigBean
{
    //配置RestTemplate
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
