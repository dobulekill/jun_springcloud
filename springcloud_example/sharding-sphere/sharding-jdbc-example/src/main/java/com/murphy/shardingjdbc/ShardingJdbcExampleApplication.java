package com.murphy.shardingjdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
public class ShardingJdbcExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShardingJdbcExampleApplication.class, args);
	}

}
