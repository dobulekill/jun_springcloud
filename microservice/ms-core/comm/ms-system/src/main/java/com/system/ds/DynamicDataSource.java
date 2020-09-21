package com.system.ds;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 实现数据源路由
 * @author yuejing
 *
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
 
    @Override
    protected Object determineCurrentLookupKey() {
        return DbContextHolder.getDbType();
    }
}