/*
 * Copyright (c) 2018. zscatcloud.net All Rights Reserved.
 * 项目名称：zscatcloud快速搭建企业级分布式微服务平台
 * 类名称：PcSpringSocialConfigurer.java
 * 创建人：刘兆明
 * 联系方式：zscatcloud.net@gmail.com
 * 开源地址: https://github.com/zscatcloud
 * 博客地址: http://blog.zscatcloud.net
 * 项目官网: http://zscatcloud.net
 */

package com.zscatcloud.security.core.social.support;

import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * 继承默认的社交登录配置，加入自定义的后处理逻辑
 *
 * @author Wujun
 */
public class PcSpringSocialConfigurer extends SpringSocialConfigurer {

	private String filterProcessesUrl;

	private SocialAuthenticationFilterPostProcessor socialAuthenticationFilterPostProcessor;

	/**
	 * Instantiates a new Pc spring social configurer.
	 *
	 * @param filterProcessesUrl the filter processes url
	 */
	public PcSpringSocialConfigurer(String filterProcessesUrl) {
		this.filterProcessesUrl = filterProcessesUrl;
	}

	/**
	 * Post process t.
	 *
	 * @param <T>    the type parameter
	 * @param object the object
	 *
	 * @return the t
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected <T> T postProcess(T object) {
		SocialAuthenticationFilter filter = (SocialAuthenticationFilter) super.postProcess(object);
		filter.setFilterProcessesUrl(filterProcessesUrl);
		if (socialAuthenticationFilterPostProcessor != null) {
			socialAuthenticationFilterPostProcessor.process(filter);
		}
		return (T) filter;
	}

	/**
	 * Gets filter processes url.
	 *
	 * @return the filter processes url
	 */
	public String getFilterProcessesUrl() {
		return filterProcessesUrl;
	}

	/**
	 * Sets filter processes url.
	 *
	 * @param filterProcessesUrl the filter processes url
	 */
	public void setFilterProcessesUrl(String filterProcessesUrl) {
		this.filterProcessesUrl = filterProcessesUrl;
	}

	/**
	 * Gets social authentication filter post processor.
	 *
	 * @return the social authentication filter post processor
	 */
	public SocialAuthenticationFilterPostProcessor getSocialAuthenticationFilterPostProcessor() {
		return socialAuthenticationFilterPostProcessor;
	}

	/**
	 * Sets social authentication filter post processor.
	 *
	 * @param socialAuthenticationFilterPostProcessor the social authentication filter post processor
	 */
	public void setSocialAuthenticationFilterPostProcessor(SocialAuthenticationFilterPostProcessor socialAuthenticationFilterPostProcessor) {
		this.socialAuthenticationFilterPostProcessor = socialAuthenticationFilterPostProcessor;
	}

}
