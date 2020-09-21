package com.zscat.goods.impl;

import com.zscat.goods.dao.TFloorGoodsDao;
import com.zscat.goods.entity.TFloorGoodsDO;
import com.zscat.goods.service.TFloorGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




/**
 * Created by GeneratorFx on 2017-04-11.
 */
/**
 * @version V1.0
 * @author: zscat
 * @date: 2018/7/10
 * @Description: TODO
 */
@Service
public class TFloorGoodsServiceImpl implements TFloorGoodsService {
	@Autowired
	private TFloorGoodsDao tFloorGoodsDao;
	
	@Override
	public TFloorGoodsDO get(Long id){
		return tFloorGoodsDao.get(id);
	}
	
	@Override
	public List<TFloorGoodsDO> list(Map<String, Object> map){
		return tFloorGoodsDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tFloorGoodsDao.count(map);
	}
	
	@Override
	public int save(TFloorGoodsDO tFloorGoods){
		return tFloorGoodsDao.save(tFloorGoods);
	}
	
	@Override
	public int update(TFloorGoodsDO tFloorGoods){
		return tFloorGoodsDao.update(tFloorGoods);
	}
	
	@Override
	public int remove(Long id){
		return tFloorGoodsDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return tFloorGoodsDao.batchRemove(ids);
	}
	
}
