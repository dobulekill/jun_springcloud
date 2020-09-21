package com.murphy.shardingjdbc.sharding;

import lombok.extern.log4j.Log4j2;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 复合分片，，有多个分片字段，逻辑相对复杂的
 * @author dongsufeng
 * @date 2019/12/5 16:55
 * @version 1.0
 */
@Log4j2
public class ComplexAlgorithm implements ComplexKeysShardingAlgorithm<Long> {
	/**
	 *
	 * @param collection 数据源集合
	 * @param complexKeysShardingValue 算法对应的分片字段和value
	 * @return 返回数据源列表
	 */
	@Override
	public Collection<String> doSharding(Collection<String> collection,
			ComplexKeysShardingValue<Long> complexKeysShardingValue) {
		Collection<Long> id = complexKeysShardingValue.getColumnNameAndShardingValuesMap().get("id");
		log.info("==================ComplexAlgorithm==========={}");
		List<String> list=new ArrayList<>();
		id.forEach(s->{
			list.add(getDatasourceByUserId(collection,s));
		});
		return list;
	}
	/**
	 * userId 分片算法.
	 */
	protected String getDatasourceByUserId(Collection<String> collection, @NonNull Long shardingValue) {
		Long bucket = shardingValue / 100;
		if (bucket > collection.size() - 1) {
			return "0";
		}
		return String.valueOf(collection.toArray()[bucket.intValue()]);
	}
}
