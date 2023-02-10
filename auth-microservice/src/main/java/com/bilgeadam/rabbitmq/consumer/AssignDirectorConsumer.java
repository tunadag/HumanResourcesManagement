package com.bilgeadam.rabbitmq.consumer;

import com.bilgeadam.dto.request.AssignDirectorRequestDto;
import com.bilgeadam.rabbitmq.model.AssignDirector;
import com.bilgeadam.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AssignDirectorConsumer {

    private final AuthService authService;

    @RabbitListener(queues = "queue-employee-assign-director")
    public void assignDirectorFromHandleQueue(AssignDirector assignDirector){
        authService.assignDirector(AssignDirectorRequestDto.builder()
                        .email(assignDirector.getEmail())
                        .role(assignDirector.getRole())
                .build());
    }
}
