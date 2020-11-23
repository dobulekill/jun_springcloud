package com.ctrip.framework.apollo.openapi.repository;

import com.ctrip.framework.apollo.openapi.entity.Consumer;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Wujun
 */
public interface ConsumerRepository extends PagingAndSortingRepository<Consumer, Long> {

  Consumer findByAppId(String appId);

}
