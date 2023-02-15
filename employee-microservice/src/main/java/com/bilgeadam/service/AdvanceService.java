package com.bilgeadam.service;

import com.bilgeadam.repository.IAdvanceRepository;
import org.springframework.stereotype.Service;

@Service
public class AdvanceService {

    private final IAdvanceRepository advanceRepository;

    public AdvanceService(IAdvanceRepository advanceRepository) {
        this.advanceRepository = advanceRepository;
    }
}
