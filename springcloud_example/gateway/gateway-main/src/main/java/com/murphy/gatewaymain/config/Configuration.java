package com.murphy.gatewaymain.config;/**
 * @author Wujun
 * @date 2019/11/19 17:24
 * @version 1.0
 */

import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import reactor.core.publisher.Mono;

/**
 *
 * @author Wujun
 * @date 2019/11/19 17:24
 * @version 1.0
 */
@org.springframework.context.annotation.Configuration
@Log4j2
public class Configuration {
	/**
	 * 过滤器
	 * order越大优先级越低
	 * 跟LoginFiter功能一样，两种实现方式
	 * @return
	 */
	@Bean
	@Order(3)
	public GlobalFilter login(){
		log.info(this.getClass().getSimpleName()+"===login");
		return ((exchange, chain) -> {
			//pre filter：在业务执行前执行
			log.info("pre filter");
			return chain.filter(exchange).then(Mono.fromRunnable(()->{
				//业务执行后执行
				log.info("post filter");
			}));
		});
	}

	/**
	 * 根据HostAddress进行限流
	 * 实际业务中可根据业务需求自定义
	 * @return
	 */
	@Bean("hostKeyResolver")
	KeyResolver hostKeyResolver() {
		return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
	}
}
