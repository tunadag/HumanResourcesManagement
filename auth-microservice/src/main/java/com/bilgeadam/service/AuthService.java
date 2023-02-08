package com.bilgeadam.service;

import com.bilgeadam.dto.request.*;
import com.bilgeadam.exception.AuthMicroserviceException;
import com.bilgeadam.exception.ErrorType;
import com.bilgeadam.manager.IEmployeeManager;
import com.bilgeadam.mapper.IAuthMapper;
import com.bilgeadam.repository.IAuthRepository;
import com.bilgeadam.repository.entity.Auth;
import com.bilgeadam.repository.entity.Employee;
import com.bilgeadam.repository.entity.Roles;
import com.bilgeadam.utility.JwtTokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final IAuthRepository repository;
    private final JwtTokenManager jwtTokenManager;
    private final IEmployeeManager employeeManager;

    public Boolean register(RegisterRequestDto dto){
        Optional<Auth> personal = repository.findOptionalByEmail(dto.getEmail());
        if (personal.isPresent()){
            throw new AuthMicroserviceException(ErrorType.REGISTER_EMAIL_KAYITLI);
        }else{
            Auth auth = repository.save(IAuthMapper.INSTANCE.fromRegisterRequestDto(dto));
            employeeManager.createEmployee(NewCreateEmployeeRequestDto.builder()
                            .authId(auth.getId())
                            .email(auth.getEmail())
                            .role(auth.getRoles())
                    .build());
            return true;
        }
    }

    public String login(LoginRequestDto dto){
        Optional<Auth> personal = repository.findOptionalByEmailAndPassword(dto.getEmail(), dto.getPassword());
        if (personal.isEmpty()){
            throw new AuthMicroserviceException(ErrorType.LOGIN_ERROR);
        }
        Optional<String> token = jwtTokenManager.createToken(personal.get().getId());
        if (token.isEmpty()){
            throw new AuthMicroserviceException(ErrorType.JWT_TOKEN_CREATE_ERROR);
        }
        return token.get();
    }

    public Boolean createDirector(CreateDirectorRequestDto dto) {
        Optional<Long> authId = jwtTokenManager.getByIdFromToken(dto.getToken());
        if (authId.isEmpty()){
            throw new RuntimeException("Geçersiz Token");
        }
        Optional<Auth> auth = repository.findOptionalById(authId.get());
        if (auth.isEmpty()){
            throw new RuntimeException("Çalışan bulunamadı");
        }
        if (auth.get().getRoles() != Roles.ADMINISTRATOR){
            throw new RuntimeException("Geçersiz giriş denemesi");
        }
        Optional<Auth> authToBeDirector = repository.findOptionalById(dto.getAuthIdToBeDirector());
        authToBeDirector.get().setRoles(Roles.DIRECTOR);
        repository.save(authToBeDirector.get());
        employeeManager.createDirector(dto);
        return true;
    }

    public List<Employee> findAll(BaseRequestDto dto) {
        Optional<Long> id = jwtTokenManager.getByIdFromToken(dto.getToken());
        if (id.isEmpty()){
            throw new AuthMicroserviceException(ErrorType.GECERSIZ_GIRIS_DENEMESI);
        }
        Optional<Auth> personal = repository.findOptionalById(id.get());
        if (personal.isEmpty()){
            throw new AuthMicroserviceException(ErrorType.GECERSIZ_GIRIS_DENEMESI);
        }
        if (personal.get().getRoles() != Roles.ADMINISTRATOR){
            throw new AuthMicroserviceException(ErrorType.GECERSIZ_GIRIS_DENEMESI);
        }
        List<Employee> employees = employeeManager.findAll().getBody();
        return employees;
    }

/*
    public Boolean updateAddress(Long id, String address){
        Optional<Auth> personal = repository.findOptionalById(id);
        if (personal.isEmpty()){
            throw new AuthMicroserviceException(ErrorType.KULLANICI_BULUNAMADI);
        }
        personal.get().setAddress(address);
        repository.save(personal.get());
        return true;
    }

    public Boolean updatePhoto(Long id, String photo){
        Optional<Auth> personal = repository.findOptionalById(id);
        if (personal.isEmpty()){
            throw new AuthMicroserviceException(ErrorType.KULLANICI_BULUNAMADI);
        }
        personal.get().setPhoto(photo);
        repository.save(personal.get());
        return true;
    }

    public Boolean updateTelephone(Long id, String telephone){
        Optional<Auth> personal = repository.findOptionalById(id);
        if (personal.isEmpty()){
            throw new AuthMicroserviceException(ErrorType.KULLANICI_BULUNAMADI);
        }
        personal.get().setTelephone(telephone);
        repository.save(personal.get());
        return true;
    }

 */
}
