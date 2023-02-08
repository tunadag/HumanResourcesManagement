package com.bilgeadam.controller;

import com.bilgeadam.dto.request.BaseRequestDto;
import com.bilgeadam.dto.request.CreateDirectorRequestDto;
import com.bilgeadam.dto.request.LoginRequestDto;
import com.bilgeadam.dto.request.RegisterRequestDto;
import com.bilgeadam.repository.entity.Employee;
import com.bilgeadam.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @PostMapping("/register")
    public ResponseEntity<Boolean> register(@RequestBody @Valid RegisterRequestDto dto){
        return ResponseEntity.ok(service.register(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginRequestDto dto){
        return ResponseEntity.ok(service.login(dto));
    }

    @PostMapping("/findall")
    public ResponseEntity<List<Employee>> findAll(@RequestBody BaseRequestDto dto){
        return ResponseEntity.ok(service.findAll(dto));
    }

    @PostMapping("/createdirector")
    public ResponseEntity<Boolean> createDirector(@RequestBody CreateDirectorRequestDto dto){
        return ResponseEntity.ok(service.createDirector(dto));
    }
}
