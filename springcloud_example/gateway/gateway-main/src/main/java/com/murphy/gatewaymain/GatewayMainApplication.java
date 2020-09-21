package com.murphy.gatewaymain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * gateway官网文档：
 * https://cloud.spring.io/spring-cloud-static/spring-cloud-gateway/2.1.0.RELEASE/single/spring-cloud-gateway.html#_redis_ratelimiter
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayMainApplication.class, args);
	}

}
