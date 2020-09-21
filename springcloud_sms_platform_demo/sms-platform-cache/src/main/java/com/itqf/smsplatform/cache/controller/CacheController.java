package com.itqf.smsplatform.cache.controller;

import com.itqf.smsplatform.cache.service.CacheService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Map;
import java.util.Set;

/**
 * author:zouningsss
 * date:Created in 2020/3/15 13:59
 * description:
 */

@RestController
@RequestMapping("/cache")
public class CacheController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CacheController.class);

    @Autowired
    private CacheService cacheService;

    /**
     * @param key
     * @param value
     * @param expireSecond
     */
    @GetMapping(value = "/save2cache")
    @ApiOperation("存储字符串类型的数据")
    public boolean save2Cache(@ApiParam(name = "key", required = true, value = "保存的 key") String key,
                              @ApiParam(name = "value", required = true, value = "保存的 value") String value,
                              @ApiParam(name = "expireSecond", required = true, value = "有效期") Integer expireSecond) {
        LOGGER.error("save2cache执行了:传递的 key 是{},value 是{},有效期是{}", key, value, expireSecond);
        cacheService.save2Cache(key, value, expireSecond);
        return true;
    }

    @GetMapping("/get/{key}")
    @ApiOperation("从 redis 中获取字符串类型的数据")
    public String get(@PathVariable String key) {
        return cacheService.get(key);
    }

    @GetMapping(value = "/save2cache/{key}/{value}")
    @ApiOperation("永久保存数据到redis")
    public boolean save2Cache(@PathVariable String key, @PathVariable String value) {
        LOGGER.error("save2cache执行了 key:{} value:{}", key, value);
        cacheService.save2Cache(key, value);
        return true;
    }
    //因为我们还没有考虑好存放的具体是对象是什么,所以暂时还无法编写获取对象的方法,实际上就是调用了 get 方法

    @RequestMapping("/getbject/{key}")
    public Object getObject(@PathVariable String key) {
        return cacheService.getObject(key);
    }

    @ApiOperation("从 redis 中删除指定 key")
    @PostMapping("/delete")
    public Long del(String... keys) {
        LOGGER.error("delete执行了 keys{}", keys);
        return cacheService.del(keys);
    }

    @PostMapping("/expire/{key}/{seconds}")
    @ApiOperation("给指定的 key 设置有效期")
    public boolean expire(@PathVariable String key, @PathVariable long seconds) {
        LOGGER.error("expire执行了 keys{} seconds{}", key, seconds);
        return cacheService.expire(key, seconds);
    }

    @GetMapping("/incr")
    @ApiOperation("递增")
    public long incr(String key, @RequestParam(defaultValue = "1") long delta) {
        LOGGER.error("incr执行了 keys{} delta{}", key, delta);
        return cacheService.incr(key, delta);
    }

    @GetMapping("/decr")
    @ApiOperation("递减")
    public long decr(String key, @RequestParam(defaultValue = "-1") long delta) {
        LOGGER.error("decr执行了 keys{} delta{}", key, delta);
        return cacheService.decr(key, delta);
    }

    @GetMapping("/hmget/{key}")
    @ApiOperation("从 redis 中获取 hash 类型的数据")
    public Map<Object, Object> hGetAll(@PathVariable String key) {

        LOGGER.error("hmget执行了 key{}", key);
        return cacheService.hGetAll(key);
    }

    /**
     * 注意,这个方法要有返回值,哪怕随便返回一个东西都行,否则调用方可能会出现空指针异常,不知道什么情况
     *
     * @param key
     * @param map
     * @return
     */
    @PostMapping("/hmset/{key}")
    @ApiOperation("保存 json 到 redis 的 hash 中")
    public boolean hMset(@PathVariable String key, @RequestBody Map<String, Object> map) {
        LOGGER.error("hMset执行了 key{} map{}", key, map);
        cacheService.hMset(key, map);
        return true;
    }

    @RequestMapping(value = "/hget/{key}/{field}", method = RequestMethod.GET)
    public String hget(@PathVariable("key") String key, @PathVariable("field") String field) {
        Object result = cacheService.hget(key, field);
        return result == null ? null : result.toString();
    }

    @RequestMapping("/keys/{keyPattern}")
    public Set<String> getKeys(@PathVariable String keyPattern) {

        return cacheService.getKeys(keyPattern);
    }


    @PostMapping("/zadd/{key}/{value}/{score}")
    public boolean zAdd(@PathVariable String key, @PathVariable String value, @PathVariable double score) {
        return cacheService.zAdd(key, value, score);
    }

    /**
     * 获取 zet 指定范围内的数据
     *
     * @param key
     * @param min
     * @param max
     */
    @RequestMapping("/zrangebyscore/{key}/{min}/{max}")
    public Set<Object> zRangeByScore(@PathVariable String key, @PathVariable double min, @PathVariable double max) {
        return cacheService.zRangeByScore(key, min, max);
    }

}
