package com.artarkatesoft.artsfgjms.sender;

import com.artarkatesoft.artsfgjms.model.HelloWorldMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static com.artarkatesoft.artsfgjms.config.JmsConfig.MY_QUEUE;

@Component
@RequiredArgsConstructor
public class HelloSender {

    private final JmsTemplate jmsTemplate;

    @Scheduled(fixedRate = 2000)
    private void send() {

        HelloWorldMessage message = HelloWorldMessage.builder()
                .id(UUID.randomUUID())
                .message("Hello from simple send")
                .build();

        jmsTemplate.convertAndSend(MY_QUEUE, message);

        System.out.println("Message sent");
    }

}
