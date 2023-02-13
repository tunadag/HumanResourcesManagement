package com.bilgeadam.utility;


import com.bilgeadam.rabbitmq.model.CreateEmployee;
import com.bilgeadam.rabbitmq.producer.CreateEmployeeProducer;
import com.bilgeadam.repository.IAuthRepository;
import com.bilgeadam.repository.entity.Auth;
import com.bilgeadam.repository.entity.Roles;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class DataImpl {

    private final IAuthRepository repository;
    private final CreateEmployeeProducer createEmployeeProducer;

    @PostConstruct
    public void initData(){
        createPersonals();
    }

    private void createPersonals() {

        Auth auth1 = Auth.builder()
                .email("hilaler@hotmail.com")
                .password("1234")
                .roles(Roles.ADMINISTRATOR)
                .build();

        Auth auth2 = Auth.builder()
                .email("ihsancan@hotmail.com")
                .roles(Roles.ADMINISTRATOR)
                .build();

        Auth auth3 = Auth.builder()
                .email("eilgar@hotmail.com")
                .roles(Roles.DIRECTOR)
                .build();

        Auth auth4 = Auth.builder()
                .email("tunadag@hotmail.com")
                .password("3456")
                .roles(Roles.PERSONAL)
                .build();

        repository.save(auth1);
        createEmployeeProducer.convertAndSendMessageCreateEmployee(CreateEmployee.builder()
                        .authId(auth1.getId())
                        .email(auth1.getEmail())
                        .role(auth1.getRoles())
                .build());

        repository.save(auth2);
        createEmployeeProducer.convertAndSendMessageCreateEmployee(CreateEmployee.builder()
                .authId(auth2.getId())
                .email(auth2.getEmail())
                .role(auth2.getRoles())
                .build());

        repository.save(auth3);
        createEmployeeProducer.convertAndSendMessageCreateEmployee(CreateEmployee.builder()
                .authId(auth3.getId())
                .email(auth3.getEmail())
                .role(auth3.getRoles())
                .build());

        repository.save(auth4);
        createEmployeeProducer.convertAndSendMessageCreateEmployee(CreateEmployee.builder()
                .authId(auth4.getId())
                .email(auth4.getEmail())
                .role(auth4.getRoles())
                .build());

    }
}



