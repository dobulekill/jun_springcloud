package com.zscat.goods.dao;


import com.zscat.goods.entity.BannerDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author Wujun
 * @email 951449465@qq.com
 * @date 2017-10-18 10:31:32
 */
@Mapper
public interface BannerDao {

	BannerDO get(Long id);
	
	List<BannerDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(BannerDO banner);
	
	int update(BannerDO banner);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
