package com.bilgeadam.controller;

import com.bilgeadam.dto.request.BaseRequestDto;
import com.bilgeadam.dto.request.CreateDirectorRequestDto;
import com.bilgeadam.dto.request.NewCreateEmployeeRequestDto;
import com.bilgeadam.dto.request.UpdateEmployeeRequestDto;
import com.bilgeadam.dto.response.UpdateEmployeeResponseDto;
import com.bilgeadam.repository.entity.Employee;
import com.bilgeadam.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<Boolean> createEmployee(@RequestBody NewCreateEmployeeRequestDto dto){
        return ResponseEntity.ok(employeeService.createEmployee(dto));
    }

    @PostMapping("/updateprofile")
    public ResponseEntity<UpdateEmployeeResponseDto> updateProfile(@RequestBody UpdateEmployeeRequestDto dto){
        return ResponseEntity.ok(employeeService.updateProfile(dto));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Employee>> findAll(){
        return ResponseEntity.ok(employeeService.findAll());
    }

    @PostMapping("/findallforadmin")
    public ResponseEntity<List<Employee>> findAllForAdmin(@RequestBody BaseRequestDto dto){
        return ResponseEntity.ok(employeeService.findAllForAdmin(dto));
    }

    @PostMapping("/createdirector")
    public ResponseEntity<Boolean> createDirector(@RequestBody CreateDirectorRequestDto dto){
        return ResponseEntity.ok(employeeService.createDirector(dto));
    }


}
