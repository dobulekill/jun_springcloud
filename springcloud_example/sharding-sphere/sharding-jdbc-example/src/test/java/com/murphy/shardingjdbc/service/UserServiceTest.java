package com.murphy.shardingjdbc.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author dongsufeng
 * @version 1.0
 * @date 2019/12/5 16:51
 */
@SpringBootTest
class UserServiceTest {
	@Autowired
	UserService userService;

	@Test
	void get() {
		userService.get(1L);
	}

	@Test
	void getMessage() {
		userService.getMessage(1L);
	}
	@Test
	void getConfig(){
		userService.getConfig("config");
	}
}