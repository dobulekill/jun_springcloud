package com.murphy.mongodb.service;

import com.alibaba.fastjson.JSON;
import com.murphy.mongodb.Repository.OrderInfoRepository;
import com.murphy.mongodb.entity.OrderInfo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author Wujun
 * @date 2020/1/7 17:29
 * @version 1.0
 */
@Service
@Log4j2
public class MongoDBService {

	@Autowired
	MongoTemplate mongoTemplate;
	@Autowired
	OrderInfoRepository orderInfoRepository;

	public void insert(OrderInfo orderInfo){
//		log.info("insert====={}", JSON.toJSONString(mongoTemplate.insert(orderInfo)));
		log.info("insert=====1=={}",JSON.toJSONString(orderInfoRepository.insert(orderInfo)));
	}
	public void insertAll(List<OrderInfo> list){
		log.info("insertAll==={}",JSON.toJSONString(mongoTemplate.insertAll(list)));
	}
	public void updateById(OrderInfo orderInfo){
		if (orderInfo!=null && orderInfo.getId()!=null){
			Query query=new Query(Criteria.where("_id").is(orderInfo.getId()));
			Update update=new Update();
			update.set("desc",orderInfo.getDesc());
			log.info("updateResult==={}",JSON.toJSONString(mongoTemplate.updateMulti(query, update, OrderInfo.class)));
		}
	}
	public void getById(Long orderNo){
		log.info("getById===={}",JSON.toJSONString(mongoTemplate.findById(orderNo,OrderInfo.class)));
		log.info("getById====1==={}",JSON.toJSONString(orderInfoRepository.getById(orderNo)));
	}
	public void getByPage(int pageIndex,int pageNo,OrderInfo orderInfo){
		Query query=new Query().limit(pageNo).skip(pageIndex);
		log.info("getByPage====={}",JSON.toJSONString(mongoTemplate.find(query,OrderInfo.class)));
		ExampleMatcher matcher=ExampleMatcher.matching()
				.withIgnorePaths("createTime","updateTime");
		Example<OrderInfo> ex = Example.of(orderInfo,matcher);
		log.info("getByPage====={}",JSON.toJSONString(orderInfoRepository.findAll(ex, PageRequest.of(pageIndex,pageNo))));
	}
	public void findAll(OrderInfo orderInfo){
		ExampleMatcher matcher=ExampleMatcher.matching()
				.withMatcher("desc",ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("createTime","updateTime")
				.withIgnoreNullValues();
		Example<OrderInfo> ex = Example.of(orderInfo,matcher);
		log.info("findAll====={}",JSON.toJSONString(orderInfoRepository.findAll(ex)));
	}
}
