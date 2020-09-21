package com.murphy.ratelimiter.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 时间区间以秒为基础单位
 * @author dongsufeng
 * @version 1.0
 * @date 2019/11/29 10:31
 */
@Retention(RUNTIME)
@Target({ METHOD })
public @interface RateLimiter {

	/**
	 * 限流策略
	 * 实现接口@link KeyResolver
	 * 必须为beanname
	 * @return
	 */
	String keyResolver() default "";

	/**
	 * 时间单位默认秒
	 * @return
	 */
	TimeUnit timeUnit() default TimeUnit.SECONDS;

	/**
	 * 时间范围
	 * @return
	 */
	int time()default 1;

	/**
	 * 时间范围内许可数
	 * @return
	 */
	int permits() default 100;
}
