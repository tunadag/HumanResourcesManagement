package com.bilgeadam.service;

import com.bilgeadam.dto.request.CreateCompanyRequestDto;
import com.bilgeadam.dto.response.CompanyResponseDto;
import com.bilgeadam.mapper.ICompanyMapper;
import com.bilgeadam.repository.ICompanyRepository;
import com.bilgeadam.repository.entity.Company;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private final ICompanyRepository companyRepository;

    public CompanyService(ICompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Boolean createCompany(CreateCompanyRequestDto dto){
        try {
            Company company = ICompanyMapper.INSTANCE.toCompany(dto);
            companyRepository.save(company);
            return true;
        }catch (Exception ex){
            throw new RuntimeException("Şirket oluşturulamadı");
        }
    }

    public List<CompanyResponseDto> showCompanies() {
        return ICompanyMapper.INSTANCE.toCompanyResponseDtos(companyRepository.findAll());
    }
}
