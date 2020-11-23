package com.murphy.elasticsearch.service;

import com.murphy.elasticsearch.document.OrderDocument;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Wujun
 * @version 1.0
 * @date 2020/1/3 18:05
 */
@SpringBootTest
class OrderEsServiceTest {
	@Autowired
	OrderEsService orderEsService;

	@Test
	void save() {
		List<OrderDocument> list=new ArrayList<>();
		OrderDocument orderDocument=null;
		for (int i = 0; i < 20; i++) {
			orderDocument=new OrderDocument();
			orderDocument.setId(i+1L);
			orderDocument.setDesc("我的王者密码是"+i);
			list.add(orderDocument);
		}
		orderEsService.save(list);
	}
	@Test
	void update() {
		OrderDocument orderDocument=null;
		orderDocument=new OrderDocument();
		orderDocument.setId(2L);
		orderDocument.setDesc("我有一个小秘密");
		orderEsService.save(orderDocument);
	}
	@Test
	void getById() {
		orderEsService.getById(2L);
	}

	@Test
	void deleteById() {
		orderEsService.deleteById(1L);
	}

	@Test
	void getByPage() {
		orderEsService.getByPage("秘密",0,12,"desc");
	}
	@Test
	void get() {
		orderEsService.get("王者",0,12,"desc");
	}
	@Test
	void deleteALL() {
		orderEsService.deleteAll();
	}
}