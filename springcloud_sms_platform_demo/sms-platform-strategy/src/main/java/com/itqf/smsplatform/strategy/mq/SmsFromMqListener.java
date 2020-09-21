package com.itqf.smsplatform.strategy.mq;

import com.itqf.smsplatform.common.constants.RabbitMqConsants;
import com.itqf.smsplatform.common.model.Standard_Submit;
import com.itqf.smsplatform.strategy.service.DataFilterManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * author:zouningsss
 * date:Created in 2020/3/17 15:27
 * description:
 */

@Component
public class SmsFromMqListener {

    @Resource
    private DataFilterManager dataFilterManager;

    private static final Logger LOGGER = LoggerFactory.getLogger(SmsFromMqListener.class);

//    @RabbitListener(queues = RabbitMqConsants.TOPIC_PRE_SEND, containerFactory = "taskContainerFactory")
//    public void receive(Standard_Submit submit) throws Exception {
//        LOGGER.error("收到的内容是：{}", submit);
//
//    }
    @RabbitListener(queues = RabbitMqConsants.TOPIC_PRE_SEND,containerFactory = "taskContainerFactory")
    public void receive(Standard_Submit submit) throws Exception{
        LOGGER.error("收到的内容是：{}",submit);
        dataFilterManager.dealSms(submit);
    }


}
