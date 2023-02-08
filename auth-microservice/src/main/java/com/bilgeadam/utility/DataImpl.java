package com.bilgeadam.utility;

/*
import com.bilgeadam.dto.request.NewCreateEmployeeRequestDto;
import com.bilgeadam.manager.IEmployeeManager;
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
    private final IEmployeeManager employeeManager;

    @PostConstruct
    public void initData(){
        createPersonals();
    }

    private void createPersonals() {

        Auth auth1 = Auth.builder()
//                .name("Hilal Zülfü")
//                .address("Ankara")
                .email("hilaler@hotmail.com")
//                .nationalId(25698103791L)
//                .photo("foto")
                .password("1234")
                .roles(Roles.ADMINISTRATOR)
                .build();

        Auth auth2 = Auth.builder()
//                .name("İhsan Can")
//                .address("İzmir")
                .email("ihsancan@hotmail.com")
//                .nationalId(28568103791L)
//                .photo("foto")
                .roles(Roles.ADMINISTRATOR)
                .build();

        Auth auth3 = Auth.builder()
//                .name("Emre Ilgar")
//                .address("İstanbul")
                .email("eilgar@hotmail.com")
//                .nationalId(32058103791L)
//                .photo("foto")
                .roles(Roles.DIRECTOR)
                .build();

        Auth auth4 = Auth.builder()
//                .name("Tuna Dağ")
//                .address("Antalya")
                .email("tunadag@hotmail.com")
//                .nationalId(32058105555L)
//                .photo("foto")
                .password("3456")
                .roles(Roles.PERSONAL)
                .build();

        repository.save(auth1);
        employeeManager.createEmployee(NewCreateEmployeeRequestDto.builder()
                        .authId(auth1.getId())
                        .email(auth1.getEmail())
                        .role(auth1.getRoles())
                .build());
        repository.save(auth2);
        employeeManager.createEmployee(NewCreateEmployeeRequestDto.builder()
                .authId(auth2.getId())
                .email(auth2.getEmail())
                .role(auth2.getRoles())
                .build());
        repository.save(auth3);
        employeeManager.createEmployee(NewCreateEmployeeRequestDto.builder()
                .authId(auth3.getId())
                .email(auth3.getEmail())
                .role(auth3.getRoles())
                .build());
        repository.save(auth4);
        employeeManager.createEmployee(NewCreateEmployeeRequestDto.builder()
                .authId(auth4.getId())
                .email(auth4.getEmail())
                .role(auth4.getRoles())
                .build());
    }
}


 */

