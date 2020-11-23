package com.ctrip.framework.apollo.biz.repository;

import com.ctrip.framework.apollo.biz.entity.ServerConfig;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Wujun
 */
public interface ServerConfigRepository extends PagingAndSortingRepository<ServerConfig, Long> {
  ServerConfig findTopByKeyAndCluster(String key, String cluster);
}
