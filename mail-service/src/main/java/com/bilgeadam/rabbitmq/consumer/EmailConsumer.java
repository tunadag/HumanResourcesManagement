package com.bilgeadam.rabbitmq.consumer;

import com.bilgeadam.rabbitmq.model.SendEmailPassword;
import com.bilgeadam.service.EmailSenderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailConsumer {

    private final EmailSenderService emailSenderService;

    @RabbitListener(queues = "queue-auth-mail")
    public void password(SendEmailPassword sendEmailPassword){

        log.info("Model {} ", sendEmailPassword.toString());
        emailSenderService.sendMail(sendEmailPassword);
    }
}
