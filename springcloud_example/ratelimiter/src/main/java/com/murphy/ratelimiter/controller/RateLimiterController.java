package com.murphy.ratelimiter.controller;

import com.murphy.ratelimiter.annotation.RateLimiter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Wujun
 * @date 2019/11/29 10:19
 * @version 1.0
 */
@RestController
@Log4j2
public class RateLimiterController {


	@PostMapping("/limiter")
	@RateLimiter(time = 60,permits = 5,keyResolver = "hostKeyResolver")
	public String rateLimiter(){
		log.info("====================");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "success";
	}

}
