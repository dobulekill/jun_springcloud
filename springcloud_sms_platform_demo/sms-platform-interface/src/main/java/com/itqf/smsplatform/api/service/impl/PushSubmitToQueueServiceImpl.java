package com.itqf.smsplatform.api.service.impl;

import com.itqf.smsplatform.api.service.PushSubmitToQueueService;
import com.itqf.smsplatform.common.constants.RabbitMqConsants;
import com.itqf.smsplatform.common.model.Standard_Submit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author:zouningsss
 * date:Created in 2020/3/16 23:14
 * description:
 */

@Service
public class PushSubmitToQueueServiceImpl implements PushSubmitToQueueService {

    @Autowired
    private RabbitTemplate template;

    @Override
    public void sendSmsSubitToQueue(List<Standard_Submit> standard_submits) {
        for (Standard_Submit submit : standard_submits) {
            //  submit.setSource(1);//source 代表的是通过 http 还是 web 的方式来发送的 1是 http
            template.convertAndSend(RabbitMqConsants.TOPIC_PRE_SEND, submit);

        }
    }

}
