package com.itqf.smsplatform.strategy.feign;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

/**
 * 缓存服务的熔断
 * 此处都没重写,实际开发中根据要求来做具体的实现
 */
@Component
public class CacheServiceFallback implements CacheService {
    @Override
    public String get(String key) {
        return "";
    }

    @Override
    public Object getObject(String key) {
        return null;
    }

    @Override
    public boolean del(String... keys) {
        return false;
    }

    @Override
    public boolean hmset(String key, Map map) {
        return false;
    }

    @Override
    public Map hmget(String key) {
        return null;
    }

    @Override
    public void set(String key, String value, Long expireSecond) {

    }

    @Override
    public void saveCache(String key, String value) {

    }

    @Override
    public Long incr(String key, long value) {
        return null;
    }

    @Override
    public String hget(String key, String field) {
        return null;
    }

    @Override
    public Set<String> getKeys(String keyPattern) {
        return null;
    }

    @Override
    public boolean zAdd(String key, String value, double score) {
        return false;
    }

    @Override
    public Set<Object> zRangeByScore(String key, double min, double max) {
        return null;
    }

    @Override
    public long decr(String key, long delta) {
        return 0;
    }

}
