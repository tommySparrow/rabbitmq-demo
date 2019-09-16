package com.rabbitmq.rabbitmqdemo.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author User
 */
@Component
@RabbitListener(queues = "q_fanout_C")
public class FanOutReceiverC {
    @RabbitHandler
    public void process(String msg) {
        System.out.println("CReceiver  : " + msg);
    }
}
