/**
 * Copyright &copy; 2016-2022 liuhangjun All rights reserved.
 */
package com.channelsharing.hongqu.supplier.api.dao;

import com.channelsharing.hongqu.supplier.api.entity.SupplierInfo;
import com.channelsharing.common.dao.CrudDao;
import org.apache.ibatis.annotations.Mapper;


/**
 * 供应商信息Dao接口
 * @author liuhangjun
 * @version 2018-02-02
 */
@Mapper
public interface SupplierInfoDao extends CrudDao<SupplierInfo> {

}
