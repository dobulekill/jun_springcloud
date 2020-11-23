package com.murphy.ratelimiter.Config;

import com.murphy.ratelimiter.aspect.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Wujun
 * @date 2019/11/29 18:53
 * @version 1.0
 */
@Configuration
public class KeyResolverConfig {

	@Bean("hostKeyResolver")
	public KeyResolver keyResolver(){
		return request -> request.getRequestURI();
	}
}
