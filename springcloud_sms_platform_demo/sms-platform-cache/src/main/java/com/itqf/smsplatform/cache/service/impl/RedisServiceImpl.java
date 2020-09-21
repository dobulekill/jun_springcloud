package com.itqf.smsplatform.cache.service.impl;

import com.itqf.smsplatform.cache.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * author:zouningsss
 * date:Created in 2020/3/15 14:04
 * description:
 */

@Service
public class RedisServiceImpl implements CacheService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void save2Cache(String key, String value, Integer expireSecond) {
        redisTemplate.opsForValue().set(key, value, expireSecond, TimeUnit.SECONDS);
    }

    @Override
    public void save2Cache(String key, Object value, Integer expireSecond) {
        redisTemplate.opsForValue().set(key, value, expireSecond, TimeUnit.SECONDS);
    }

    @Override
    public void save2Cache(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public void save2Cache(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public String get(String key) {

//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setValueSerializer(new StringRedisSerializer());
        Object result = redisTemplate.opsForValue().get(key);
        return (String) result;
    }

    @Override
    public Object getObject(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public Long del(String... keys) {
        return redisTemplate.delete(CollectionUtils.arrayToList(keys));

    }

    @Override
    public boolean expire(String key, long seconds) {
        return redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
    }

    @Override
    public long incr(String key, long delta) {
        return redisTemplate.opsForValue().increment(key, delta);
    }

    @Override
    public long decr(String key, long delta) {
        return redisTemplate.opsForValue().decrement(key, delta);
    }

    @Override
    public Map<Object, Object> hGetAll(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    @Override
    public void hMset(String key, Map<String, Object> map) {
        redisTemplate.opsForHash().putAll(key, map);
    }

    @Override
    public Object hget(String key, String field) {
        return redisTemplate.opsForHash().get(key, field);
    }

    @Override
    public Set<String> getKeys(String keyPattern) {
        return redisTemplate.keys(keyPattern);
    }

    @Override
    public boolean zAdd(String key, String value, double score) {
        redisTemplate.opsForZSet().add(key, value, score);
        return true;
    }

    @Override
    public Set<Object> zRangeByScore(String key, double min, double max) {
        Set<Object> objects = redisTemplate.opsForZSet().rangeByScore(key, min, max);
        return objects;
    }
}
