package com.bilgeadam.service;

import com.bilgeadam.dto.request.AllowanceRequestDto;
import com.bilgeadam.mapper.IAllowanceMapper;
import com.bilgeadam.repository.IAllowanceRepository;
import com.bilgeadam.repository.entity.Allowance;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class AllowanceService {

    private final IAllowanceRepository allowanceRepository;

    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");

    public AllowanceService(IAllowanceRepository allowanceRepository) {
        this.allowanceRepository = allowanceRepository;
    }

    public Boolean requestAllowance(AllowanceRequestDto dto){
        try {
            Allowance allowance = IAllowanceMapper.INSTANCE.toAllowance(dto);
            allowance.setRequestDate(sdf.format(new Date(System.currentTimeMillis())));
            allowanceRepository.save(allowance);
            return true;
        } catch (Exception ex){
            throw new RuntimeException("Harcırah talebiniz oluşturulamadı.");
        }
    }
}
