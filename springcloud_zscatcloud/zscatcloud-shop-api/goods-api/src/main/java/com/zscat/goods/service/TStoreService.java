package com.zscat.goods.service;

import com.zscat.goods.entity.TStoreDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author Wujun
 * @email 951449465@qq.com
 * @date 2017-10-15 15:07:37
 */
public interface TStoreService {
	
	TStoreDO get(Long id);
	
	List<TStoreDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TStoreDO tStore);
	
	int update(TStoreDO tStore);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
