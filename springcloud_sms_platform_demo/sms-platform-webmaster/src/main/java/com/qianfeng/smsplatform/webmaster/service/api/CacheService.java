package com.qianfeng.smsplatform.webmaster.service.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(value = "SMS-PLATFORM-CACHE", fallback = CacheServiceFallback.class)
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
    public Long incr(@RequestParam("key") String key, @RequestParam("delta") long value);

}
