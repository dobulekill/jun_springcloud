/*
 * Copyright (c) 2018. zscatcloud.net All Rights Reserved.
 * 项目名称：zscatcloud快速搭建企业级分布式微服务平台
 * 类名称：SessionRegistryCenterConfiguration.java
 * 创建人：刘兆明
 * 联系方式：zscatcloud.net@gmail.com
 * 开源地址: https://github.com/zscatcloud
 * 博客地址: http://blog.zscatcloud.net
 * 项目官网: http://zscatcloud.net
 */

package com.zscatcloud.core.utils;

import com.zscatcloud.config.properties.ZookeeperProperties;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 注册中心配置的会话声明周期.
 *
 * @author zhangliang
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SessionRegistryCenterConfiguration {

	private static ZookeeperProperties regCenterConfig;

	/**
	 * 从当前会话范围获取注册中心配置.
	 *
	 * @return 事件追踪数据源配置
	 */
	public static ZookeeperProperties getRegistryCenterConfiguration() {
		return regCenterConfig;
	}

	/**
	 * 设置注册中心配置至当前会话范围.
	 *
	 * @param regCenterConfig 注册中心配置
	 */
	public static void setRegistryCenterConfiguration(final ZookeeperProperties regCenterConfig) {
		SessionRegistryCenterConfiguration.regCenterConfig = regCenterConfig;
	}
}
