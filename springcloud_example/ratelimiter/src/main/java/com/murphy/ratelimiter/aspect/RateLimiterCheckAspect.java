package com.murphy.ratelimiter.aspect;

import com.murphy.ratelimiter.annotation.RateLimiter;
import com.murphy.ratelimiter.core.RateLimiterRunner;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 *
 * @author dongsufeng
 * @date 2019/11/29 10:54
 * @version 1.0
 */
@Log4j2
@Aspect
@Component
public class RateLimiterCheckAspect {
	@Autowired
	private RateLimiterRunner rateLimiterRunner;
	@Autowired
	BeanFactory beanFactory;


	/**
	 * 前置处理，限流拦截
	 * @return
	 * @throws Exception
	 */
	@Around("execution(public * com.murphy.ratelimiter.controller..*.*(..))")
	public Object bedLoginClassValid(ProceedingJoinPoint point) throws Throwable {
		MethodSignature joinPointObject = (MethodSignature) point.getSignature();
		RateLimiter rateLimiter = joinPointObject.getMethod().getAnnotation(RateLimiter.class);
		if (rateLimiter==null){
			return true;
		}
		String keyResolver = rateLimiter.keyResolver();
		HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
		if (StringUtils.isEmpty(keyResolver)){
			keyResolver=request.getRequestURI();
		}else {
			KeyResolver bean = beanFactory.getBean(keyResolver,KeyResolver.class);
			keyResolver = bean.resolve(request);
		}
		log.info("===========keyResolver={}",keyResolver);
		if (rateLimiterRunner.checkRun(keyResolver, rateLimiter.permits(), rateLimiter.time(), rateLimiter.timeUnit())){
			Object[] args = point.getArgs();
			return point.proceed(args);
		}
		return "被限流";
	}
}
