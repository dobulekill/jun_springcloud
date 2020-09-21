package com.murphy.gatewaydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GatewayDemo2Application {

	public static void main(String[] args) {
		SpringApplication.run(GatewayDemo2Application.class, args);
	}

}
