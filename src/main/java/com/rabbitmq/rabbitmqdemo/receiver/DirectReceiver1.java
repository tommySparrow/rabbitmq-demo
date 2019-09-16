package com.rabbitmq.rabbitmqdemo.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2018/10/17
 * @ Description：
 * @ throws
 */
@Component
@RabbitListener(queues = "direct.message")
public class DirectReceiver1 {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("DirectReceiver1:" + msg);
    }
}
