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
@RabbitListener(queues = "lyhTest2")
public class Receiver2 {

    @RabbitHandler
    public void receiver(String msg){
        System.out.println("Test1 receiver2:"+msg);
    }
}
