package com.bilgeadam.service;

import com.bilgeadam.dto.request.BaseRequestDto;
import com.bilgeadam.dto.request.CreateDirectorRequestDto;
import com.bilgeadam.dto.request.NewCreateEmployeeRequestDto;
import com.bilgeadam.dto.request.UpdateEmployeeRequestDto;
import com.bilgeadam.dto.response.UpdateEmployeeResponseDto;
import com.bilgeadam.exception.EmployeeMicroserviceException;
import com.bilgeadam.exception.ErrorType;
import com.bilgeadam.mapper.IEmployeeMapper;
import com.bilgeadam.repository.IEmployeeRepository;
import com.bilgeadam.repository.entity.Employee;
import com.bilgeadam.repository.entity.Roles;
import com.bilgeadam.utility.JwtTokenManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final IEmployeeRepository employeeRepository;
    private final JwtTokenManager jwtTokenManager;

    public EmployeeService(IEmployeeRepository employeeRepository, JwtTokenManager jwtTokenManager){
        this.employeeRepository = employeeRepository;
        this.jwtTokenManager = jwtTokenManager;
    }


    public Boolean createEmployee(NewCreateEmployeeRequestDto dto){
        try {
            Employee employee = IEmployeeMapper.INSTANCE.toEmployee(dto);
            employee.setCreatedDate(System.currentTimeMillis());
            employeeRepository.save(employee);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            throw new EmployeeMicroserviceException(ErrorType.USER_NOT_CREATED);
        }
    }

    public UpdateEmployeeResponseDto updateProfile(UpdateEmployeeRequestDto dto){
        Optional<Long> id = verifyToken(dto.getToken());
        Optional<Employee> employee = employeeRepository.findOptionalByAuthId(id.get());
        if (employee.isEmpty()){
            throw new RuntimeException("Personel bulunamadı.");
        }
        employee.get().setDepartment(dto.getDepartment());
        employee.get().setAddress(dto.getAddress());
        employee.get().setTelephone(dto.getTelephone());
        employee.get().setSurname(dto.getSurname());
        employee.get().setPhoto(dto.getPhoto());
        employee.get().setUpdatedDate(System.currentTimeMillis());
        employeeRepository.save(employee.get());
        return IEmployeeMapper.INSTANCE.toUpdateResponseDto(employee.get());
    }

    public Optional<Long> verifyToken(String token){
        Optional<Long> id = jwtTokenManager.getByIdFromToken(token);
        if (id.isEmpty()){
            throw new RuntimeException("Geçersiz Token");
        }
        return id;
    }

    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public List<Employee> findAllForAdmin(BaseRequestDto dto){
        Optional<Long> authId = jwtTokenManager.getByIdFromToken(dto.getToken());
        if (authId.isEmpty()){
            throw new RuntimeException("Geçersiz Token");
        }
        Optional<Employee> employee = employeeRepository.findOptionalByAuthId(authId.get());
        if (employee.isEmpty()){
            throw new RuntimeException("Çalışan bulunamadı");
        }
        if (employee.get().getRole() != Roles.ADMINISTRATOR){
            throw new RuntimeException("Geçersiz giriş denemesi");
        }
        return employeeRepository.findAll();
    }

    public Boolean createDirector(CreateDirectorRequestDto dto) {
        Optional<Long> authId = jwtTokenManager.getByIdFromToken(dto.getToken());
        if (authId.isEmpty()){
            throw new RuntimeException("Geçersiz Token");
        }
        Optional<Employee> employee = employeeRepository.findOptionalByAuthId(authId.get());
        if (employee.isEmpty()){
            throw new RuntimeException("Çalışan bulunamadı");
        }
        if (employee.get().getRole() != Roles.ADMINISTRATOR){
            throw new RuntimeException("Geçersiz giriş denemesi");
        }
        Optional<Employee> employeeToBeDirector = employeeRepository.findOptionalByAuthId(dto.getAuthIdToBeDirector());
        employeeToBeDirector.get().setRole(Roles.DIRECTOR);
        employeeRepository.save(employeeToBeDirector.get());
        return true;
    }

}
