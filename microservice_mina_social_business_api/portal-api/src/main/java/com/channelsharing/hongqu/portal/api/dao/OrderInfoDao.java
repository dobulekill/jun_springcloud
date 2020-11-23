/**
 * Copyright &copy; 2016-2022 liuhangjun All rights reserved.
 */
package com.channelsharing.hongqu.portal.api.dao;

import com.channelsharing.hongqu.portal.api.entity.OrderInfo;
import com.channelsharing.common.dao.CrudDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单信息Dao接口
 * @author Wujun
 * @version 2018-06-20
 */
@Mapper
public interface OrderInfoDao extends CrudDao<OrderInfo> {
    
    void cancelOrder(OrderInfo entity);

}
