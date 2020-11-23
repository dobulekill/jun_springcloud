package com.zccoder.cloud2.ch9.bus.config.client.eureka.rabbitmq;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <br>
 * 标题: 启动类<br>
 * 描述: 启动类<br>
 * 时间: 2018/10/04<br>
 *
 * @author Wujun
 */
@EnableDiscoveryClient
@SpringBootApplication
public class BusConfigClientEurekaRabbitmqApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(BusConfigClientEurekaRabbitmqApplication.class).web(true).run(args);
    }

}
