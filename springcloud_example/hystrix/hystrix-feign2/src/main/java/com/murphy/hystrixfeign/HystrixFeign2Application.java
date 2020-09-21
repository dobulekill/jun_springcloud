package com.murphy.hystrixfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
//@EnableFeignClients
@EnableHystrix
public class HystrixFeign2Application {

	public static void main(String[] args) {
		SpringApplication.run(HystrixFeign2Application.class, args);
	}

}
