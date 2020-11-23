package com.murphy.mongodb.Repository;

import com.murphy.mongodb.entity.OrderInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Wujun
 * @date 2020/1/7 17:59
 * @version 1.0
 */
public interface OrderInfoRepository extends MongoRepository<OrderInfo,Long> {
	OrderInfo getById(Long orderNo);
}
