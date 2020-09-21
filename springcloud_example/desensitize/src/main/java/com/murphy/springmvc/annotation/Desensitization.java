package com.murphy.springmvc.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.murphy.springmvc.enums.DesensitionType;
import com.murphy.springmvc.desensitize.JacksonDesensitize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 需要脱敏的对象
 * @author dongsufeng
 * @version 1.0
 * @date 2019/12/18 18:17
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@JsonSerialize(using = JacksonDesensitize.class)
@JacksonAnnotationsInside
public @interface Desensitization {

	/**
	 * 脱敏规则类型
	 * @return
	 */
	DesensitionType type();

	/**
	 * 附加值, 自定义正则表达式等
	 * @return
	 */
	String[] attach() default "";

}
