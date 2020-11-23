/**
 * Copyright &copy; 2016-2022 liuhangjun All rights reserved.
 */
package com.channelsharing.hongqu.supplier.api.dao;

import com.channelsharing.hongqu.supplier.api.entity.OrderGoods;
import com.channelsharing.common.dao.CrudDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单的商品信息Dao接口
 * @author Wujun
 * @version 2018-07-01
 */
@Mapper
public interface OrderGoodsDao extends CrudDao<OrderGoods> {

}
