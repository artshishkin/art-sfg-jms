package com.artarkatesoft.artsfgjms.sender;

import com.artarkatesoft.artsfgjms.model.HelloWorldMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import java.util.UUID;

import static com.artarkatesoft.artsfgjms.config.JmsConfig.MY_QUEUE;
import static com.artarkatesoft.artsfgjms.config.JmsConfig.MY_SEND_RCV_QUEUE;

@Component
@RequiredArgsConstructor
public class HelloSender {

    private final JmsTemplate jmsTemplate;
    private final ObjectMapper objectMapper;

    @Scheduled(fixedRate = 2000)
    private void send() {

        HelloWorldMessage message = HelloWorldMessage.builder()
                .id(UUID.randomUUID())
                .message("Hello from simple send")
                .build();

        jmsTemplate.convertAndSend(MY_QUEUE, message);

//        System.out.println("Message sent");
    }

    @Scheduled(fixedRate = 1500)
    private void sendAndReceive() throws JMSException {

        HelloWorldMessage messageSent = HelloWorldMessage.builder()
                .id(UUID.randomUUID())
                .message("Hello there")
                .build();
        System.out.println("Message sent: " + messageSent);

        Message messageReceived = jmsTemplate.sendAndReceive(MY_SEND_RCV_QUEUE, session -> {
            try {
                TextMessage helloMessage = session.createTextMessage(objectMapper.writeValueAsString(messageSent));
                helloMessage.setStringProperty("_type", HelloWorldMessage.class.getName());
                return helloMessage;
            } catch (JsonProcessingException e) {
                throw new JMSException(e.getMessage());
            }
        });

        System.out.println("Message received back: " + messageReceived.getBody(String.class));


    }

}
