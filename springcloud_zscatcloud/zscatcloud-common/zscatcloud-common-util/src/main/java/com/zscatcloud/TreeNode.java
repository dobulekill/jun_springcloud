/*
 * Copyright (c) 2018. zscatcloud.net All Rights Reserved.
 * 项目名称：zscatcloud快速搭建企业级分布式微服务平台
 * 类名称：TreeNode.java
 * 创建人：刘兆明
 * 联系方式：zscatcloud.net@gmail.com
 * 开源地址: https://github.com/zscatcloud
 * 博客地址: http://blog.zscatcloud.net
 * 项目官网: http://zscatcloud.net
 */

package com.zscatcloud;

import lombok.Data;

import java.util.List;

/**
 * The class Tree node.
 *
 * @author Wujun
 */
@Data
public class TreeNode {
	/**
	 * 节点编码
	 */
	private String nodeCode;
	/**
	 * 节点名称
	 */
	private String nodeName;
	/**
	 * ID
	 */
	private Long id;
	/**
	 * 父ID
	 */
	private Long pid;
	/**
	 * 孩子节点信息
	 */
	private List<TreeNode> children;

}
