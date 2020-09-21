package com.itqf.smsplatform.strategy.service.impl;

import com.itqf.smsplatform.common.constants.RabbitMqConsants;
import com.itqf.smsplatform.common.model.Standard_Submit;
import com.itqf.smsplatform.strategy.service.QueueService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * author:zouning
 * date:Created in 2020/4/11 22:11
 * description:
 */


public class QueueServiceImpl implements QueueService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendSubmitToMQ(Standard_Submit standard_submit, String errorCode) {
        standard_submit.setErrorCode(errorCode);
        standard_submit.setReportState(2);
        standard_submit.setSendTime(new Date());
        rabbitTemplate.convertAndSend(RabbitMqConsants.TOPIC_SMS_SEND_LOG,standard_submit);
    }

    @Override
    public void sendSmsReport(Standard_Submit standard_submit, String errorCode) {
        //
    }
}
