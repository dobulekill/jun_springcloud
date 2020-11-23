package com.murphy.gatewaymain.filter;/**
 * @author Wujun
 * @date 2019/11/19 17:35
 * @version 1.0
 */

import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 *
 * @author Wujun
 * @date 2019/11/19 17:35
 * @version 1.0
 */
@Log4j2
@Component
@Order(2)
public class LoginFilter implements GlobalFilter {
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		log.info("login pre filter");
		return chain.filter(exchange).then(Mono.fromRunnable(()->{
			log.info("login post filter");
		}));
	}
}
