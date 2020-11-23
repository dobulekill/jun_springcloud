package com.murphy.ratelimiter.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 *
 * @author Wujun
 * @date 2019/11/29 17:06
 * @version 1.0
 */
@Configuration
public class RedisConfig {

	@Bean
	public RedisTemplate<String,String> redisTemplate(RedisConnectionFactory redisConnectionFactory){
		return new StringRedisTemplate(redisConnectionFactory);
	}
}
