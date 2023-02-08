package com.bilgeadam.controller;

import com.bilgeadam.dto.request.CreateCompanyRequestDto;
import com.bilgeadam.dto.response.CompanyResponseDto;
import com.bilgeadam.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping("/create")
    public ResponseEntity<Boolean> createCompany(@RequestBody CreateCompanyRequestDto dto){
        return ResponseEntity.ok(companyService.createCompany(dto));
    }

    @GetMapping("/showcompanies")
    public ResponseEntity<List<CompanyResponseDto>> showCompanies(){
        return ResponseEntity.ok(companyService.showCompanies());
    }
}
