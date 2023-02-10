package com.bilgeadam.rabbitmq.producer;

import com.bilgeadam.rabbitmq.model.CreateEmployee;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateEmployeeProducer {

    private final RabbitTemplate rabbitTemplate;

    public void convertAndSendMessageCreateEmployee(CreateEmployee createEmployee){
        rabbitTemplate.convertAndSend("exchange-auth", "key-auth", createEmployee);
    }
}
