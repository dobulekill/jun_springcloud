package com.murphy.ratelimiter.aspect;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author dongsufeng
 * @date 2019/11/29 18:27
 * @version 1.0
 */
public interface KeyResolver {
	/**
	 * 自定义KeyResolver
	 * 如ip，用户
	 * @param request
	 * @return
	 */
	String resolve(HttpServletRequest request);
}
