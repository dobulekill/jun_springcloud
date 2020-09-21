package com.murphy.hystrixfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {"com.murphy"})
@EnableFeignClients(basePackages = {"com.murphy.feignapi"})
@EnableHystrixDashboard
@EnableHystrix
public class HystrixFeign1Application {

	public static void main(String[] args) {
		SpringApplication.run(HystrixFeign1Application.class, args);
	}

}
