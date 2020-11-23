/*
 * Copyright (c) 2018. zscatcloud.net All Rights Reserved.
 * 项目名称：zscatcloud快速搭建企业级分布式微服务平台
 * 类名称：TreeUtils.java
 * 创建人：刘兆明
 * 联系方式：zscatcloud.net@gmail.com
 * 开源地址: https://github.com/zscatcloud
 * 博客地址: http://blog.zscatcloud.net
 * 项目官网: http://zscatcloud.net
 */

package com.zscatcloud.core.support;


import com.zscatcloud.base.dto.BaseTree;

import java.io.Serializable;

/**
 * The class Tree utils.
 *
 * @author Wujun
 */
public class TreeUtils<T extends BaseTree<T, ID>, ID extends Serializable> extends AbstractTreeService<T, ID> {

}
