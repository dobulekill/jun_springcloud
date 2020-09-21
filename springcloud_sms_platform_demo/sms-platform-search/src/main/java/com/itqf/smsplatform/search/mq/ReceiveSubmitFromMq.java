package com.itqf.smsplatform.search.mq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itqf.smsplatform.common.constants.RabbitMqConsants;
import com.itqf.smsplatform.common.model.Standard_Submit;
import com.itqf.smsplatform.search.service.SearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * author:zouning
 * date:Created in 2020/4/11 21:51
 * description:
 */

@Component
public class ReceiveSubmitFromMq {
    static final Logger logger = LoggerFactory.getLogger(ReceiveSubmitFromMq.class);

    @Autowired
    private SearchService searchService;

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = RabbitMqConsants.TOPIC_SMS_SEND_LOG,containerFactory = "")
    public void receiveSubmit(Standard_Submit standard_submit){
        try {
            logger.error("收到发送的消息",standard_submit);
            searchService.add(objectMapper.writeValueAsString(standard_submit));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
