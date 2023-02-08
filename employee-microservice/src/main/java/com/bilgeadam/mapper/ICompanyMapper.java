package com.bilgeadam.mapper;

import com.bilgeadam.dto.request.CreateCompanyRequestDto;
import com.bilgeadam.dto.response.CompanyResponseDto;
import com.bilgeadam.repository.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ICompanyMapper {
    ICompanyMapper INSTANCE = Mappers.getMapper(ICompanyMapper.class);

    Company toCompany(final CreateCompanyRequestDto dto);
    List<CompanyResponseDto> toCompanyResponseDtos(final List<Company> company);
    Company toCompany(final CompanyResponseDto dto);
}
