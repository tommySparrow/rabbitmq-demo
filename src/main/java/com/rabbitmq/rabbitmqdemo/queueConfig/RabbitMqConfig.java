package com.rabbitmq.rabbitmqdemo.queueConfig;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2018/10/17
 * @ Description：队列配置:队列的名称，发送者和接受者的名称必须一致，否则接收不到消息
 * @ throws
 */
@Configuration
public class RabbitMqConfig {
    @Bean
    public Queue Queue1() {
        return new Queue("lyhTest1");
    }
    @Bean
    public Queue Queue2() {
        return new Queue("lyhTest2");
    }
}
