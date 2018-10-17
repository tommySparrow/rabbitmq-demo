package com.rabbitmq.rabbitmqdemo.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2018/10/17
 * @ Description：
 * @ throws
 */
@RestController
public class SendController {
    @Autowired
    private AmqpTemplate amqpTemplate;

    //一对一发送
    @RequestMapping("/send")
    public String send(){
        String content="Date:"+new Date();
        amqpTemplate.convertAndSend("lyhTest1",content);
        return content;
    }

    //一对多发送消息
    @RequestMapping("/multiSend")
    public String multiSend(){
        StringBuilder times=new StringBuilder();
        for(int i=0;i<10;i++){
            long time=System.nanoTime();
            amqpTemplate.convertAndSend("lyhTest1","第"+i+"次发送的时间："+time);
            times.append(time+"<br>");
        }
        return times.toString();
    }

    //多对多发送
    @RequestMapping("/multi2MultiSend")
    public String mutil2MutilSend(){
        StringBuilder times=new StringBuilder();
        for(int i=0;i<10;i++){
            long time=System.nanoTime();
            amqpTemplate.convertAndSend("lyhTest1","第"+i+"次发送的时间："+time);
            amqpTemplate.convertAndSend("lyhTest2","第"+i+"次发送的时间："+time);
            times.append(time+"<br>");
        }
        return times.toString();
    }

    //topic模式
    @RequestMapping("/topicSend1")
    public String  topicSend1() {
        String context = "my topic 1";
        System.out.println("发送者说 : " + context);
        this.amqpTemplate.convertAndSend("exchange", "topic.message", context);
        return context;
    }
    @RequestMapping("/topicSend2")
    public String topicSend2() {
        String context = "my 00 2";
        System.out.println("发送者说 : " + context);
        this.amqpTemplate.convertAndSend("exchange", "topic.messages", context);
        return  context;
    }
}
