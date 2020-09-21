package com.murphy.springmvc.advice;

import com.alibaba.fastjson.JSONObject;
import com.murphy.springmvc.desensitize.FastjsonDesensitizeFilter;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 *
 * @author dongsufeng
 * @date 2019/12/18 16:16
 * @version 1.0
 */
@ControllerAdvice
@Log4j2
public class LogResponseAdvice implements ResponseBodyAdvice {
	@Override
	public boolean supports(MethodParameter returnType, Class converterType) {
		return true;
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
		log.info("requestUrl 【{}】 request body 【{}】",request.getURI(),JSONObject.toJSONString(body,new FastjsonDesensitizeFilter()));
		return body;
	}
}
