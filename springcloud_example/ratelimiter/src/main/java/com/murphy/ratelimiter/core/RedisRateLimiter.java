package com.murphy.ratelimiter.core;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Wujun
 * @date 2019/11/29 14:29
 * @version 1.0
 */
@Component
@Log4j2
public class RedisRateLimiter {

	@Autowired
	ApplicationContext applicationContext;
	@Autowired
	RedisTemplate<String,String> redisTemplate;
	private static final String LUA_SECOND_SCRIPT = " local current; "
			+ " local lcurrent;"
			+ " lcurrent = redis.call('get',KEYS[1]) "
			+ " if tonumber(lcurrent) == nil then "
			+ " 	current = redis.call('incr',KEYS[1]); "
			+ " 	redis.call('expire',KEYS[1],ARGV[1]); "
			+ "		return 1; "
			+ "	else "
			+ " 	if tonumber(lcurrent) > tonumber(ARGV[2]) then "
			+ "			return -1; "
			+ "	    else "
			+ " 		current = redis.call('incr',KEYS[1]); "
			+ "			return 1; "
			+ "     end "
			+ " end "

			;

	public boolean acquire(String key,int permits,int time, TimeUnit timeUnit){
		try {
			StringBuilder redisKey=new StringBuilder("RL:");
			redisKey.append(applicationContext.getApplicationName()).append(":");
			redisKey.append(key);
			RedisScript<Long> script=RedisScript.of(LUA_SECOND_SCRIPT,Long.class);
			List<String> keys=new ArrayList<>(1);
			keys.add(redisKey.toString());
			log.info("===================={}",keys.get(0));
			String [] args={timeConvert(time,timeUnit),String.valueOf(permits)};
			String s = redisTemplate.opsForValue().get(redisKey.toString());
			log.info("========================{}",s);
			return redisTemplate.execute(script, keys, args)>0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	private String timeConvert(int time,TimeUnit timeUnit){
		switch (timeUnit){
			case SECONDS:{
				return String.valueOf(time);
			}
			case MINUTES:{
				return String.valueOf(time*60);
			}
			case HOURS:{
				return String.valueOf(time*60*60);
			}
			case DAYS:{
				return String.valueOf(time*60*60*24);
			}
			default:{
				return String.valueOf(time);
			}
		}
	}
}
