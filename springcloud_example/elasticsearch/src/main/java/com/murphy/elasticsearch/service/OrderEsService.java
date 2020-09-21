package com.murphy.elasticsearch.service;

import com.alibaba.fastjson.JSON;
import com.murphy.elasticsearch.document.OrderDocument;
import com.murphy.elasticsearch.repository.OrderDocumentRepository;
import lombok.extern.log4j.Log4j2;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author dongsufeng
 * @date 2020/1/3 17:13
 * @version 1.0
 */
@Service
@Log4j2
public class OrderEsService {

	@Autowired
	OrderDocumentRepository orderDocumentRepository;
	@Autowired
	ElasticsearchTemplate elasticsearchTemplate;

	/**
	 * 保持列表
	 * @param orderDocuments
	 */
	public void save(List<OrderDocument> orderDocuments){
		elasticsearchTemplate.putMapping(OrderDocument.class);
		if (orderDocuments!=null && orderDocuments.size()>0){
			orderDocumentRepository.saveAll(orderDocuments).forEach(e->log.info("save======{}",JSON.toJSONString(e)));
		}
	}

	/**
	 * 保持单个-包含新增修改
	 * @param orderDocument
	 */
	public void save(OrderDocument orderDocument){
		if (orderDocument!=null && orderDocument.getId()!=null){
			log.info("save==={}",JSON.toJSONString(orderDocumentRepository.save(orderDocument)));
		}
	}

	/**
	 * 按id查询
	 * @param id
	 */
	public void getById(Long id){
		if (id!=null){
			orderDocumentRepository.findById(id).ifPresent(e->log.info("getById===={}",JSON.toJSONString(e)));
		}
	}

	/**
	 * 按id删除
	 * @param id
	 */
	public void deleteById(Long id){
		if (id!=null){
			orderDocumentRepository.deleteById(id);
		}
	}

	/**
	 * elasticsearchTemplate实现分页查询
	 * @param keyword 查询的关键字
	 * @param pageIndex 开始页
	 * @param pageNo 每页条数
	 * @param fieldName 搜索的字段名称数组
	 */
	public void getByPage(String keyword,int pageIndex,int pageNo,String ... fieldName){
		QueryBuilder queryBuilder = QueryBuilders.multiMatchQuery(keyword, fieldName)   // matchQuery(),单字段搜索
				.analyzer("ik_max_word").operator(Operator.OR);
		SearchQuery searchQuery=new NativeSearchQueryBuilder()
				.withQuery(queryBuilder)
				.withPageable(PageRequest.of(pageIndex,pageNo))
				.build();
		AggregatedPage<OrderDocument> orderDocuments = elasticsearchTemplate
				.queryForPage(searchQuery, OrderDocument.class);
		List<OrderDocument> collect = orderDocuments.get().collect(Collectors.toList());
		collect.forEach(e->log.info("getByPage====={}",JSON.toJSONString(e)));
	}

	/**
	 * orderDocumentRepository实现分页查询
	 * @param keyword
	 * @param pageIndex
	 * @param pageNo
	 * @param fieldName
	 */
	public void get(String keyword,int pageIndex,int pageNo,String ... fieldName){
		QueryBuilder queryBuilder = QueryBuilders.multiMatchQuery(keyword, fieldName)   // matchQuery(),单字段搜索
				.analyzer("ik_max_word").operator(Operator.OR);
		Page<OrderDocument> search = orderDocumentRepository.search(queryBuilder, PageRequest.of(pageIndex, pageNo));
		List<OrderDocument> collect = search.get().collect(Collectors.toList());
		collect.forEach(e->log.info("get====={}",JSON.toJSONString(e)));
	}

	/**
	 * 删除索引下的所有数据
	 */
	public void deleteAll(){
		orderDocumentRepository.deleteAll();
	}
}
