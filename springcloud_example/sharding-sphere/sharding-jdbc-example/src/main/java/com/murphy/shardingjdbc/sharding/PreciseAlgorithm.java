package com.murphy.shardingjdbc.sharding;

import lombok.extern.log4j.Log4j2;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.springframework.lang.NonNull;

import java.util.Collection;

/**
 * 精准算法-一个分片字段
 * @author dongsufeng
 * @date 2019/12/5 17:21
 * @version 1.0
 */
@Log4j2
public class PreciseAlgorithm implements PreciseShardingAlgorithm<Long> {
	/**
	 *
	 * @param collection 数据源集合
	 * @param preciseShardingValue 分片键对应value
	 * @return 匹配的数据源
	 */
	@Override
	public String doSharding(Collection collection, PreciseShardingValue preciseShardingValue) {
		Long value = (Long) preciseShardingValue.getValue();
		log.info("==================PreciseAlgorithm==========={}",value);
		return getDatasourceByUserId(collection,value);
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
