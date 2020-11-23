package com.zccoder.cloud2.ch9.bus.config.server.eureka.kafka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * <br>
 * 标题: 启动类<br>
 * 描述: 启动类<br>
 * 时间: 2018/10/04<br>
 *
 * @author Wujun
 */
@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
public class BusConfigServerEurekaKafkaApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(BusConfigServerEurekaKafkaApplication.class).web(true).run(args);
    }

}
