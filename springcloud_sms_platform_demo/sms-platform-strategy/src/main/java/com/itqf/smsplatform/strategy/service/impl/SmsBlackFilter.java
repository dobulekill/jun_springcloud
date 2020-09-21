package com.itqf.smsplatform.strategy.service.impl;

import com.itqf.smsplatform.common.constants.CacheConstants;
import com.itqf.smsplatform.common.constants.StrategyConstants;
import com.itqf.smsplatform.common.model.Standard_Submit;
import com.itqf.smsplatform.strategy.exception.DataProcessException;
import com.itqf.smsplatform.strategy.feign.CacheService;
import com.itqf.smsplatform.strategy.service.FilterChain;
import com.itqf.smsplatform.strategy.service.QueueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * author:zouningsss
 * date:Created in 2020/3/17 17:31
 * description:
 */

@Service
public class SmsBlackFilter implements FilterChain {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataFilterManagerImplFromRedis.class);
    @Autowired
    private CacheService cacheService;
    @Autowired
    private QueueService queueService;

    @Override
    public boolean dealSms(Standard_Submit submit) throws DataProcessException {
        LOGGER.error("SmsBlackFilter执行了:{}", submit);
        //此处需要判断当前要发送的号码是不是在黑名单里面,如果是就不给他发送信息
        //如何判断,凡是遇到如何,怎么做等等等等的时候都必须有数据来做判断
        //当前的手机号是什么,第二个黑名单是什么,在哪放着呢?
        //假设我们把黑名单放到了 redis 中
        //判断手机号在不在黑名单中
        //我们可以直接用黑名单的手机号作为key 放到 redis,判断这个手机号是不是黑名单 最简单办法就是作为 key 去获取一下数据,能获取到就代表是黑名单,获取不到就代表不是黑名单
        String result = cacheService.get(CacheConstants.CACHE_PREFIX_BLACK + submit.getDestMobile());
        if (StringUtils.isEmpty(result)) {
            //代表没有这个 key 就说明不是黑名单
            LOGGER.error("当前手机号:{}不在黑名单中", submit.getDestMobile());
            return true;
        } else {
            //统计数据
            LOGGER.error("当前手机号:{}是黑名单", submit.getDestMobile());
            //TODO 发送数据到 es来进行统计
            queueService.sendSubmitToMQ(submit, StrategyConstants.STRATEGY_ERROR_BLACK);
            queueService.sendSmsReport(submit, StrategyConstants.STRATEGY_ERROR_BLACK);
        }
        return false;

    }

}
