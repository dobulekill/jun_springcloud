/*
 * Copyright (c) 2018. zscatcloud.net All Rights Reserved.
 * 项目名称：zscatcloud快速搭建企业级分布式微服务平台
 * 类名称：Weixin.java
 * 创建人：刘兆明
 * 联系方式：zscatcloud.net@gmail.com
 * 开源地址: https://github.com/zscatcloud
 * 博客地址: http://blog.zscatcloud.net
 * 项目官网: http://zscatcloud.net
 */

package com.zscatcloud.security.core.social.weixin.api;

/**
 * 微信API调用接口
 *
 * @author Wujun
 */
public interface Weixin {

	/**
	 * Gets user info.
	 *
	 * @param openId the open id
	 *
	 * @return the user info
	 */
	WeixinUserInfo getUserInfo(String openId);

}
