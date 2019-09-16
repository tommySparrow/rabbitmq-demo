package com.rabbitmq.rabbitmqdemo.queueConfig;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqDirectConfig {

    final static String MESSAGE = "direct.message";

    @Bean
    public Queue queue(){
        return new Queue(MESSAGE, false, false, false);
    }

    //声明交换机,不同类型的交换机对应不同类
    @Bean
    public DirectExchange ex(){
        return new DirectExchange("exchangeOfDirect");
    }

    //路由绑定关系
    @Bean
    public Binding bind(){
        return BindingBuilder.bind(queue()).to(ex()).with("direct.message");
    }

}
