package com.bilgeadam.controller;

import com.bilgeadam.dto.request.AllowanceRequestDto;
import com.bilgeadam.service.AllowanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/allowance")
@RequiredArgsConstructor
public class AllowanceController {

    private final AllowanceService allowanceService;

    @PostMapping("/request")
    public ResponseEntity<Boolean> requestAllowance(@RequestBody AllowanceRequestDto dto){
        return ResponseEntity.ok(allowanceService.requestAllowance(dto));
    }

}
