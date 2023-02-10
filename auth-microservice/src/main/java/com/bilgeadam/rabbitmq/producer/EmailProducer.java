package com.bilgeadam.rabbitmq.producer;

import com.bilgeadam.rabbitmq.model.SendEmailPassword;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailProducer {

    private String exchangeAuth = "exchange-auth";
    private String keyMail = "key-mail";

    private final RabbitTemplate rabbitTemplate;

    public void sendPassword(SendEmailPassword sendEmailPassword){
        rabbitTemplate.convertAndSend(exchangeAuth, keyMail, sendEmailPassword);
    }
}
