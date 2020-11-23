package com.murphy.gatewaymain.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;

/**
 *
 * @author Wujun
 * @date 2019/11/26 10:27
 * @version 1.0
 */
@RestController
@Log4j2
public class MessageHystrixFallbackController {

	@GetMapping("/message/fallback")
	public String fallback(ServerWebExchange exchange,Throwable throwable){
		if (throwable.getCause()!=null){
			log.info("==========1{}",throwable.getCause().getMessage(),throwable);
		}else {
			log.info("==========2{}",throwable.getMessage(),throwable);
		}
		ServerHttpRequest request = exchange.getRequest();
		return "123"+request.getMethodValue();
	}
}
