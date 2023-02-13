package com.bilgeadam.service;

import com.bilgeadam.dto.request.AssignDirectorRequestDto;
import com.bilgeadam.dto.request.LoginRequestDto;
import com.bilgeadam.dto.request.NewPasswordRequestDto;
import com.bilgeadam.dto.request.RegisterRequestDto;
import com.bilgeadam.exception.AuthMicroserviceException;
import com.bilgeadam.exception.ErrorType;
import com.bilgeadam.mapper.IAuthMapper;
import com.bilgeadam.rabbitmq.model.CreateEmployee;
import com.bilgeadam.rabbitmq.model.SendEmailPassword;
import com.bilgeadam.rabbitmq.producer.CreateEmployeeProducer;
import com.bilgeadam.rabbitmq.producer.EmailProducer;
import com.bilgeadam.repository.IAuthRepository;
import com.bilgeadam.repository.entity.Auth;
import com.bilgeadam.utility.JwtTokenManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final IAuthRepository authRepository;
 //   private final IEmployeeManager employeeManager;
    private final JwtTokenManager jwtTokenManager;
    private final CreateEmployeeProducer createEmployeeProducer;
    private final EmailProducer emailProducer;


    public AuthService(IAuthRepository authRepository, //IEmployeeManager employeeManager,
                       JwtTokenManager jwtTokenManager, CreateEmployeeProducer createEmployeeProducer, EmailProducer emailProducer){
        super();
        this.authRepository = authRepository;
 //       this.employeeManager = employeeManager;
        this.jwtTokenManager = jwtTokenManager;
        this.createEmployeeProducer = createEmployeeProducer;
        this.emailProducer = emailProducer;
    }


    public Boolean register(RegisterRequestDto dto){
        Optional<Auth> personal = authRepository.findOptionalByEmail(dto.getEmail());
        if (personal.isPresent()){
            throw new AuthMicroserviceException(ErrorType.REGISTER_EMAIL_KAYITLI);
        }else{
            Auth auth = authRepository.save(IAuthMapper.INSTANCE.fromRegisterRequestDto(dto));
            createEmployeeProducer.convertAndSendMessageCreateEmployee(CreateEmployee.builder()
                            .authId(auth.getId())
                            .email(auth.getEmail())
                            .role(auth.getRoles())
                    .build());
            emailProducer.sendPassword(SendEmailPassword.builder()
                            .email(auth.getEmail())
                            .password(auth.getPassword())
                    .build());
//            employeeManager.createEmployee(NewCreateEmployeeRequestDto.builder()
//                            .authId(auth.getId())
//                            .email(auth.getEmail())
//                            .role(auth.getRoles())
//                    .build());
            return true;
        }
    }

    public String login(LoginRequestDto dto){
        Optional<Auth> personal = authRepository.findOptionalByEmailAndPassword(dto.getEmail(), dto.getPassword());
        if (personal.isEmpty()){
            throw new AuthMicroserviceException(ErrorType.LOGIN_ERROR);
        }
        Optional<String> token = jwtTokenManager.createToken(personal.get().getId());
        if (token.isEmpty()){
            throw new AuthMicroserviceException(ErrorType.JWT_TOKEN_CREATE_ERROR);
        }
        return token.get();
    }

    public Boolean assignDirector(AssignDirectorRequestDto dto) {
        Optional<Auth> authToBeDirector = authRepository.findOptionalByEmail(dto.getEmail());
        authToBeDirector.get().setRoles(dto.getRole());
        authRepository.save(authToBeDirector.get());
        return true;
    }

    public Optional<Auth> findById(Long authId) {
        Optional<Auth> auth = authRepository.findById(authId);
        return auth;
    }

    public void forgotMyPassword(NewPasswordRequestDto dto){
        Optional<Auth> auth = authRepository.findOptionalByEmail(dto.getEmail());
        if (auth.isPresent()){
            emailProducer.sendPassword(SendEmailPassword.builder()
                    .email(auth.get().getEmail())
                    .password(auth.get().getPassword())
                    .build());
        } else {
            throw new AuthMicroserviceException(ErrorType.KULLANICI_BULUNAMADI);
        }
    }


/*
    public List<Employee> findAll(BaseRequestDto dto) {
        Optional<Long> id = jwtTokenManager.getByIdFromToken(dto.getToken());
        if (id.isEmpty()){
            throw new AuthMicroserviceException(ErrorType.GECERSIZ_GIRIS_DENEMESI);
        }
        Optional<Auth> personal = authRepository.findOptionalById(id.get());
        if (personal.isEmpty()){
            throw new AuthMicroserviceException(ErrorType.GECERSIZ_GIRIS_DENEMESI);
        }
        if (personal.get().getRoles() != Roles.ADMINISTRATOR){
            throw new AuthMicroserviceException(ErrorType.GECERSIZ_GIRIS_DENEMESI);
        }
        List<Employee> employees = employeeManager.findAll().getBody();
        return employees;
    }

 */

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
