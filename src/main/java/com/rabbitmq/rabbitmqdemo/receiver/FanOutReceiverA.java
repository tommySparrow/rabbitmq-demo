package com.rabbitmq.rabbitmqdemo.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author User
 */
@Component
@RabbitListener(queues = "q_fanout_A")
public class FanOutReceiverA {
    @RabbitHandler
    public void process(String msg) {
        System.out.println("AReceiver  : " + msg);
    }
}
