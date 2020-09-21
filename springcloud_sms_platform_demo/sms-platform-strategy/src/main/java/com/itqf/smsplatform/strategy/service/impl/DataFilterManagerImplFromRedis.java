package com.itqf.smsplatform.strategy.service.impl;

import com.itqf.smsplatform.common.constants.CacheConstants;
import com.itqf.smsplatform.common.model.Standard_Submit;
import com.itqf.smsplatform.strategy.exception.DataProcessException;
import com.itqf.smsplatform.strategy.feign.CacheService;
import com.itqf.smsplatform.strategy.service.DataFilterManager;
import com.itqf.smsplatform.strategy.service.FilterChain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * author:zouningsss
 * date:Created in 2020/3/17 17:25
 * description:
 */


public class DataFilterManagerImplFromRedis implements DataFilterManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataFilterManagerImplFromRedis.class);

    @Autowired
    private CacheService cacheService;

    //一个保存着名字和过滤器之间映射关系的 map,spring会自动创建我们所有声明了相关注解的对象,然后对象会被保存到map 中,按照名字会保存一份,默认是类型的首字母小写
    @Autowired
    private Map<String, FilterChain> filterChainMap;

    @Override
    public void dealSms(Standard_Submit submit) {
        //当前我们的配置是保存在 redis 中的,那些现在我们应该先从 redis 中获取这个属性的值
        //这个数据在 redis 中应该是怎样保存的,我个人感觉应该是和发短信的当前的用户相关的
        //获取当前用户需要经过的过滤器
        String filters = cacheService.hget(CacheConstants.CACHE_PREFIX_CLIENT + submit.getClientID(), "filters");
        if (filters == null) {
            //TODO 记录日志并返回
            return;
        }
        String[] requirFilters = filters.split(",");//获取到所有需要经过的过滤器,数据中顺序就是过滤器顺序

        if (requirFilters != null && submit != null) {
            for (String filter : requirFilters) { //遍历我们需要经过的所有的过滤器的字符串,拿到的每个字符串就是过滤器的名字,拿到的顺序就是过滤器的顺序

                try {
                    //根据名字来获取到当前这个过滤器
                    FilterChain filterChain = filterChainMap.get(filter);
                    if (filterChain != null) {
                        boolean result = filterChain.dealSms(submit);
                        //如果返回结果是 false 代表当前过滤器校验失败,我们应该跳出循环,直接返回,因为后面的过滤器就没有必要校验了
                        if (!result) {
                            LOGGER.error("过滤器返回了fasle:{}", filterChain);
                            break;
                        }
                    }
                } catch (DataProcessException e) {
                    e.printStackTrace();
                    LOGGER.error("过滤器发生异常:{}", e.getMsg());
                }
            }
        }
    }
}
