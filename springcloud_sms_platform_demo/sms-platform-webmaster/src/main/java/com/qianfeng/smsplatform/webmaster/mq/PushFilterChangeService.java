package com.qianfeng.smsplatform.webmaster.mq;


import com.itqf.smsplatform.common.constants.RabbitMqConsants;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * author:zouningsss
 * date:Created in 2020/3/17 17:37
 * description:
 */

public interface PushFilterChangeService {
    @Output(RabbitMqConsants.TOPIC_FILTER_UPDATE)
//发送到这个交换机
    MessageChannel message_channel();
}
