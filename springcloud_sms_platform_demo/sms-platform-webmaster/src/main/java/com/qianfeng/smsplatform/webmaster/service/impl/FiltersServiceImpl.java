package com.qianfeng.smsplatform.webmaster.service.impl;


import com.itqf.smsplatform.common.constants.CacheConstants;
import com.qianfeng.smsplatform.webmaster.dao.FiltersMapper;
import com.qianfeng.smsplatform.webmaster.mq.PushFilterChangeService;
import com.qianfeng.smsplatform.webmaster.pojo.TFilters;
import com.qianfeng.smsplatform.webmaster.service.FiltersService;
import com.qianfeng.smsplatform.webmaster.service.api.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

/**
 * author:zouningsss
 * date:Created in 2020/3/17 17:35
 * description:
 */

@Service
public class FiltersServiceImpl implements FiltersService {
    @Autowired
    private FiltersMapper mapper;
    @Autowired
    private CacheService cacheService;
    @Autowired
    private PushFilterChangeService filterChangeService;

    @Override
    public int updateFilters(String filterOrder, String filters) throws Exception {
        int update = mapper.updateFilters(filterOrder, filters);
        if (update == 1) {
            //如果数据库中有这个数据,才更新到 redis
            cacheService.saveCache(CacheConstants.CACHE_PREFIX_SMS_FILTERS_ORDER + filterOrder, filters);
            //已经添加到 redis,但是我们的策略模块并不知道,我们需要通知策略模块
            MessageChannel channel = filterChangeService.message_channel();
            //发送消息,随便发送一个内容,主要让消费者知道我们发生了内容变化的情况
            channel.send(new GenericMessage<String>("suibianxie"));
        }

        return update;
    }

    @Override
    public void addFilters(TFilters filter) throws Exception {
        mapper.addFilters(filter);
        //添加到数据库中之后顺便添加到缓存中
        cacheService.saveCache(CacheConstants.CACHE_PREFIX_SMS_FILTERS_ORDER + filter.getFilterorder(), filter.getFilters());
        //上面已经更新完 redis 了,但是策略模块不知道,我们需要通知策略模块
        MessageChannel channel = filterChangeService.message_channel();
        //发送消息,随便发送一个内容,主要让消费者知道我们发生了内容变化的情况
        channel.send(new GenericMessage<String>("suibianxie"));
    }

}
