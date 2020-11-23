/**
 * Copyright &copy; 2016-2022 liuhangjun All rights reserved.
 */
package com.channelsharing.hongqu.portal.api.dao;

import com.channelsharing.common.dao.CrudDao;
import com.channelsharing.hongqu.portal.api.entity.ShopGoodsCategory;
import org.apache.ibatis.annotations.Mapper;

/**
 * 店铺的商品分类Dao接口
 * @author Wujun
 * @version 2018-06-27
 */
@Mapper
public interface ShopGoodsCategoryDao extends CrudDao<ShopGoodsCategory> {

}
