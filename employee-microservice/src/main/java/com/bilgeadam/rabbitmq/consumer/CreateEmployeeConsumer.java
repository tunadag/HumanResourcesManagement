package com.bilgeadam.rabbitmq.consumer;

import com.bilgeadam.dto.request.NewCreateEmployeeRequestDto;
import com.bilgeadam.rabbitmq.model.CreateEmployee;
import com.bilgeadam.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateEmployeeConsumer {

    private final EmployeeService employeeService;

    @RabbitListener(queues = "queue-auth-create-employee")
    public void createEmployeeFromHandleQueue(CreateEmployee createEmployee){
        employeeService.createEmployee(NewCreateEmployeeRequestDto.builder()
                        .authId(createEmployee.getAuthId())
                        .email(createEmployee.getEmail())
                        .role(createEmployee.getRole())
                .build());
    }
}
