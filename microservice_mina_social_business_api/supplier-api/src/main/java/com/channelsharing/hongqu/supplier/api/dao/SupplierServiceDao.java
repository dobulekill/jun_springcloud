/**
 * Copyright &copy; 2016-2022 liuhangjun All rights reserved.
 */
package com.channelsharing.hongqu.supplier.api.dao;

import com.channelsharing.common.dao.CrudDao;
import com.channelsharing.hongqu.supplier.api.entity.SupplierService;
import org.apache.ibatis.annotations.Mapper;

/**
 * 供应商售后服务Dao接口
 * @author Wujun
 * @version 2018-08-08
 */
@Mapper
public interface SupplierServiceDao extends CrudDao<SupplierService> {

}