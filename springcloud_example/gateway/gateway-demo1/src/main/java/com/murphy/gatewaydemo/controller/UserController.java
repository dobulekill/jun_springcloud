package com.murphy.gatewaydemo.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dongsufeng
 * @date 2019/11/19 16:41
 * @version 1.0
 */
@RestController
@Log4j2
public class UserController {

	@GetMapping("user")
	public String get(String userId){
		log.info("userController========================={}=userId={}",this.getClass().getSimpleName(),userId);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this.getClass().getSimpleName();
	}
}
