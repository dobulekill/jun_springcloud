package com.zscat.goods.dao;

import com.zscat.goods.entity.TCartDO;
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
public interface TCartDao {

	TCartDO get(Long id);
	
	List<TCartDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TCartDO tCart);
	
	int update(TCartDO tCart);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	List<TCartDO> batchGet(String[] ids);

	List<TCartDO> list1(Map<String, Object> map);

	/**
	 * 计算前
	 * @param map
	 * @return
	 */
	String countprice(Map<String, Object> map);
}
