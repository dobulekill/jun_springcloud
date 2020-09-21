package com.itqf.smsplatform.api.mq;

import com.itqf.smsplatform.common.constants.RabbitMqConsants;
import com.itqf.smsplatform.common.model.Standard_Report;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * author:zouningsss
 * date:Created in 2020/3/16 22:48
 * description:
 */

@Component
public class ReceiveFromMQListener {
    @RabbitListener(queues = RabbitMqConsants.TOPIC_PUSH_SMS_REPORT,containerFactory = "taskContainerFactory")
    public void onMessage(Standard_Report report){
        //收到状态报告了

    }
}
