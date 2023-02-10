package com.bilgeadam.rabbitmq.producer;

import com.bilgeadam.rabbitmq.model.AssignDirector;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AssignDirectorProducer {

    private final RabbitTemplate rabbitTemplate;

    public void convertAndSendMessageAssignDirector(AssignDirector assignDirector){
        rabbitTemplate.convertAndSend("exchange-employee", "key-employee", assignDirector);
    }
}
