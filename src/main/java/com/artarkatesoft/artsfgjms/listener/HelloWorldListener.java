package com.artarkatesoft.artsfgjms.listener;

import com.artarkatesoft.artsfgjms.config.JmsConfig;
import com.artarkatesoft.artsfgjms.model.HelloWorldMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class HelloWorldListener {

    @JmsListener(destination = JmsConfig.MY_QUEUE)
    public void listen(@Payload HelloWorldMessage helloWorldMessage, @Headers MessageHeaders messageHeaders, Message message) {

//        System.out.println("Got a message");
//        System.out.println(helloWorldMessage);

//        throw new RuntimeException("not finished transaction");
    }

    @JmsListener(destination = JmsConfig.MY_SEND_RCV_QUEUE)
    public HelloWorldMessage listenAndReply(@Payload HelloWorldMessage helloWorldMessage) {

        return HelloWorldMessage.builder()
                .id(UUID.randomUUID())
                .message("And you too [" + helloWorldMessage.getMessage().toUpperCase() + "]")
                .build();
    }
}
