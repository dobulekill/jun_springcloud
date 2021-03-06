package com.zscat.order.dao;

import com.zscat.order.entity.TGoodSorderDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


/**
 * 
 * @author Wujun
 * @email 951449465@qq.com
 * @date 2017-10-15 15:07:36
 */
@Mapper
public interface TGoodSorderDao {

	TGoodSorderDO get(Long id);
	
	List<TGoodSorderDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TGoodSorderDO tGoodSorder);
	
	int update(TGoodSorderDO tGoodSorder);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

    List<TGoodSorderDO> listGoodsByUid(Long id);
}
