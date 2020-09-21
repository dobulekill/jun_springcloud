package com.itqf.smsplatform.search.config;

import com.itqf.smsplatform.common.constants.RabbitMqConsants;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMqConfig {
    //并发消费者的数量
    public static final int DEFAULT_CONSUMERS = 1;
    //每个消费者每次获取多少条信息
    public static final int DEFAULT_PREFETCH_COUNT = 50;


    @Bean
    public Queue sendLogQueue(){
        return new Queue(RabbitMqConsants.TOPIC_SMS_SEND_LOG,true);
    }



    //并发的消费配置
    @Bean("taskContainerFactory")
    public SimpleRabbitListenerContainerFactory  containerFactory(
            SimpleRabbitListenerContainerFactoryConfigurer configurer,ConnectionFactory connectionFactory){
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setPrefetchCount(DEFAULT_PREFETCH_COUNT);
        factory.setConcurrentConsumers(DEFAULT_CONSUMERS);

        configurer.configure(factory,connectionFactory);
        return factory;
    }
}
