package com.zscat.order.impl;

import com.zscat.order.dao.TGoodSorderDao;
import com.zscat.order.entity.TGoodSorderDO;
import com.zscat.order.service.TGoodSorderService;
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
public class TGoodSorderServiceImpl implements TGoodSorderService {
	@Autowired
	private TGoodSorderDao tGoodSorderDao;
	
	@Override
	public TGoodSorderDO get(Long id){
		return tGoodSorderDao.get(id);
	}
	
	@Override
	public List<TGoodSorderDO> list(Map<String, Object> map){
		return tGoodSorderDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tGoodSorderDao.count(map);
	}
	
	@Override
	public int save(TGoodSorderDO tGoodSorder){
		return tGoodSorderDao.save(tGoodSorder);
	}
	
	@Override
	public int update(TGoodSorderDO tGoodSorder){
		return tGoodSorderDao.update(tGoodSorder);
	}
	
	@Override
	public int remove(Long id){
		return tGoodSorderDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return tGoodSorderDao.batchRemove(ids);
	}
	@Override
	public List<TGoodSorderDO> listGoodsByUid(Long id){
		return tGoodSorderDao.listGoodsByUid(id);
	}
}
