package com.murphy.shardingjdbc.sharding;

import com.google.common.collect.Range;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 范围分片，如果没有规律的范围可用这个
 * 瞎写的，，仅供参考
 * @author Wujun
 * @date 2019/12/5 17:39
 * @version 1.0
 */
public class RangeAlgorithm implements RangeShardingAlgorithm<Long> {

	@Override
	public Collection<String> doSharding(Collection availableTargetNames, RangeShardingValue shardingValue) {
		Range valueRange = shardingValue.getValueRange();
		Long baseNum=100L;
		List<String> list=new ArrayList<>();
		for (int i = 0; i < availableTargetNames.size(); i++) {
			if(Range.closedOpen(i*baseNum,i*baseNum+baseNum).encloses(valueRange)){
				list.add(availableTargetNames.toArray()[i].toString());
				return list;
			}
		}
		list.add(String.valueOf(availableTargetNames.toArray()[0])) ;
		return list;
	}
}
