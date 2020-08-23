package com.artarkatesoft.artsfgjms.listener;

import com.artarkatesoft.artsfgjms.config.JmsConfig;
import com.artarkatesoft.artsfgjms.model.HelloWorldMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@Component
public class HelloWorldListener {

    @JmsListener(destination = JmsConfig.MY_QUEUE)
    public void listen(@Payload HelloWorldMessage helloWorldMessage, @Headers MessageHeaders messageHeaders, Message message) {

        System.out.println("Got a message");
        System.out.println(helloWorldMessage);

//        throw new RuntimeException("not finished transaction");
    }
}
