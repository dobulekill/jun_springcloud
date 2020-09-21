package com.itqf.smsplatform.strategy.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@FeignClient(value = "CACHE-SERVICE", fallback = CacheServiceFallback.class)
public interface CacheService {
    @RequestMapping(value = "/cache/get/{key}", method = RequestMethod.GET)
    String get(@PathVariable("key") String key);

    @RequestMapping(value = "/cache/getbject/{key}", method = RequestMethod.GET)
    Object getObject(@PathVariable("key") String key);

    @RequestMapping(value = "/cache/delete", method = RequestMethod.POST)
    boolean del(@RequestParam("keys") String... keys);

    @RequestMapping(value = "/cache/hmset/{key}", method = RequestMethod.POST)
    boolean hmset(@PathVariable("key") String key, @RequestBody Map map);

    @RequestMapping(value = "/cache/hmget/{key}", method = RequestMethod.GET)
    public Map hmget(@PathVariable("key") String key);

    @RequestMapping(value = "/cache/save2cache", method = RequestMethod.GET)
    void set(@RequestParam("key") String key, @RequestParam("value") String value, @RequestParam("expireSecond") Long expireSecond);

    @RequestMapping(value = "/cache/save2cache/{key}/{value}", method = RequestMethod.GET)
    void saveCache(@PathVariable("key") String key, @PathVariable("value") String value);

    @RequestMapping(value = "/cache/incr", method = RequestMethod.GET)
    Long incr(@RequestParam("key") String key, @RequestParam("delta") long value);

    @RequestMapping(value = "/cache/hget/{key}/{field}", method = RequestMethod.GET)
    String hget(@PathVariable("key") String key, @PathVariable("field") String field);

    @RequestMapping("/cache/keys/{keyPattern}")
    Set<String> getKeys(@PathVariable String keyPattern);

    @PostMapping("/cache/zadd/{key}/{value}/{score}")
    public boolean zAdd(@PathVariable String key, @PathVariable String value, @PathVariable double score);

    /**
     * 获取 zet 指定范围内的数据
     *
     * @param key
     * @param min
     * @param max
     */
    @RequestMapping("/cache/zrangebyscore/{key}/{min}/{max}")
    public Set<Object> zRangeByScore(@PathVariable String key, @PathVariable double min, @PathVariable double max);


    @GetMapping("/cache/decr")
    public long decr(@RequestParam("key") String key, @RequestParam("delta") long delta);

}
