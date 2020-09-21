/*
 * Copyright (c) 2018. zscatcloud.net All Rights Reserved.
 * 项目名称：zscatcloud快速搭建企业级分布式微服务平台
 * 类名称：ShardingContextDto.java
 * 创建人：刘兆明
 * 联系方式：zscatcloud.net@gmail.com
 * 开源地址: https://github.com/zscatcloud
 * 博客地址: http://blog.zscatcloud.net
 * 项目官网: http://zscatcloud.net
 */
package com.zscatcloud.base.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The class Sharding context dto.
 *
 * @author zscatcloud.net @gmail.com
 */
@Data
@NoArgsConstructor
public class ShardingContextDto {
	/**
	 * The Sharding total count.
	 */
	int shardingTotalCount;
	/**
	 * The Sharding item.
	 */
	int shardingItem;

	public ShardingContextDto(final int shardingTotalCount, final int shardingItem) {
		this.shardingTotalCount = shardingTotalCount;
		this.shardingItem = shardingItem;
	}
}
