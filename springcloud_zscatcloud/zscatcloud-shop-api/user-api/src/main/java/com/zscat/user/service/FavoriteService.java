package com.zscat.user.service;


import com.zscat.user.entity.FavoriteDO;

import java.util.List;
import java.util.Map;


/**
 * 
 * 
 * @author Wujun
 * @email 951449465@qq.com
 * @date 2017-10-21 11:21:45
 */
public interface FavoriteService {
	
	FavoriteDO get(Long id);
	
	List<FavoriteDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(FavoriteDO favorite);
	
	int update(FavoriteDO favorite);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	FavoriteDO selectOne(Map<String, Object> params);

}
