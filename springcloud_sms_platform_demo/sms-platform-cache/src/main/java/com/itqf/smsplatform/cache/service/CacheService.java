package com.itqf.smsplatform.cache.service;

import java.util.Map;
import java.util.Set;

/**
 * author:zouningsss
 * date:Created in 2020/3/15 14:03
 * description:
 */


public interface CacheService {
    /**
     * 保存数据到缓存中
     *
     * @param key
     * @param value
     * @param expireSecond
     */
    void save2Cache(String key, String value, Integer expireSecond);

    void save2Cache(String key, Object value, Integer expireSecond);

    void save2Cache(String key, Object value);

    void save2Cache(String key, String value);

    /**
     * 查询
     *
     * @param key
     * @return
     */
    String get(String key);

    /**
     * 如果当时放的是对象,取出来应该转成对象
     *
     * @param key
     * @return
     */
    Object getObject(String key);

    /**
     * 删除 key
     *
     * @param keys
     * @return
     */
    Long del(String... keys);

    /**
     * 设置有效期
     *
     * @param key
     * @param seconds
     * @return
     */
    boolean expire(String key, long seconds);

    /**
     * 自增
     *
     * @param key
     * @param delta 步长
     * @return
     */
    long incr(String key, long delta);

    /**
     * 自减
     *
     * @param key
     * @param delta
     * @return
     */
    long decr(String key, long delta);

    /**
     * 查询 hash 的所有数据
     *
     * @param key
     * @return
     */
    Map<Object, Object> hGetAll(String key);

    /**
     * hash 的存放数据
     *
     * @param key
     * @param map
     */
    void hMset(String key, Map<String, Object> map);

    /**
     * 从 hash 中获取某个属性的值
     *
     * @param key
     * @param field
     * @return
     */
    Object hget(String key, String field);

    /**
     * 查询 redis 中以符合表达式的 key
     *
     * @param keyPattern
     * @return
     */
    Set<String> getKeys(String keyPattern);

    /**
     * 向 redis 中存放 zet 数据
     *
     * @param key
     * @param value
     * @param score
     * @return
     */
    boolean zAdd(String key, String value, double score);

    /**
     * 获取 zet 指定范围内的数据
     *
     * @param key
     * @param min
     * @param max
     */
    Set<Object> zRangeByScore(String key, double min, double max);

}
