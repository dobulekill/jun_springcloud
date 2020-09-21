package com.itqf.smsplatform.api.config;

import com.itqf.smsplatform.common.constants.RabbitMqConsants;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * author:zouningsss
 * date:Created in 2020/3/16 23:37
 * description:
 */

@Configuration
public class RabbitmqConfig {
    //并发的消费者的数量
    public static final int DEFAULT_CONSUMERS = 10;
    //每个消费者每次最多获取多少条消息
    public static final int DEFAULT_PREFETCH_COUNT = 50;

    /**
     * 声明一个队列,防止我们发送消息的时候这个队列还不存在
     * true 代表持久化队列,会对队列中的消息进行持久化,防止程序崩溃的时候消息丢失
     *
     * @return
     */
    @Bean
    public Queue preSendQueue() {
        return new Queue(RabbitMqConsants.TOPIC_PRE_SEND, true);
    }


    /**
     * 接收状态报告推送结果给客户的队列
     *
     * @return
     */
    @Bean
    public Queue pushSmsReportQueue() {
        return new Queue(RabbitMqConsants.TOPIC_PUSH_SMS_REPORT);
    }


    /**
     * 并发的消费配置
     *
     * @param configurer
     * @param connectionFactory
     * @return
     */
    @Bean("taskContainerFactory")
    public SimpleRabbitListenerContainerFactory taskContainerFactory(SimpleRabbitListenerContainerFactoryConfigurer configurer, ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setPrefetchCount(DEFAULT_PREFETCH_COUNT);
        factory.setConcurrentConsumers(DEFAULT_CONSUMERS);
        configurer.configure(factory, connectionFactory);
        return factory;
    }
}
