package com.murphy.mongodb.service;

import com.murphy.mongodb.entity.OrderInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Wujun
 * @version 1.0
 * @date 2020/1/7 17:58
 */
@SpringBootTest
class MongoDBServiceTest {
	@Autowired
	MongoDBService mongoDBService;

	@Test
	void insert() {
		OrderInfo orderInfo=new OrderInfo();
		orderInfo.setId(3000L);
		orderInfo.setOrderNo("orderNo-000002");
		orderInfo.setDesc("MongoDB-1000");
		mongoDBService.insert(orderInfo);
	}

	@Test
	void insertAll() {
		List<OrderInfo> list=new ArrayList<>();
		for (int i=0;i<50;i++){
			OrderInfo orderInfo=new OrderInfo();
			orderInfo.setId(3001L+i);
			orderInfo.setOrderNo("orderNo-"+i);
			orderInfo.setDesc("MongoDB-1000"+1);
			list.add(orderInfo);
		}
		mongoDBService.insertAll(list);
	}

	@Test
	void updateById() {
		OrderInfo orderInfo=new OrderInfo();
		orderInfo.setId(3000L);
		orderInfo.setDesc("MongoDB-test");
		mongoDBService.updateById(orderInfo);
	}

	@Test
	void getById() {
		mongoDBService.getById(3000L);
	}

	@Test
	void getByPage() {
		OrderInfo orderInfo=new OrderInfo();
		orderInfo.setDesc("MongoDB-10001");
		mongoDBService.getByPage(1,1,orderInfo);
	}
	@Test
	void findAll(){
		OrderInfo orderInfo=new OrderInfo();
		orderInfo.setDesc("MongoDB-10001");
		mongoDBService.findAll(orderInfo);
	}
}