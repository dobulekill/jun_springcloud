package com.forezp.blogservice.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    public static final String queueName="spring-boot";

    @Bean
    Queue queue(){
        return new Queue(queueName,false);
    }

    @Bean
    TopicExchange exchange(){
        return new TopicExchange("spring-boot-exchange");
    }
    Binding binding(Queue queue,TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(queueName);
    }
}
