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
@RabbitListener(queues = "lyhTest1")
public class Receiver3 {

    @RabbitHandler
    public void receiver(String msg){
        System.out.println("Test3 receiver3:"+msg);
    }
}
