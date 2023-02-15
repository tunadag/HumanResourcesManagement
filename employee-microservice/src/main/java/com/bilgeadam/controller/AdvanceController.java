package com.bilgeadam.controller;

import com.bilgeadam.service.AllowanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/advance")
@RequiredArgsConstructor
public class AdvanceController {

    private final AllowanceService allowanceService;
}
