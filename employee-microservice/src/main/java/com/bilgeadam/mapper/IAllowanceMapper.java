package com.bilgeadam.mapper;

import com.bilgeadam.dto.request.AllowanceRequestDto;
import com.bilgeadam.repository.entity.Allowance;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface IAllowanceMapper {

    IAllowanceMapper INSTANCE = Mappers.getMapper(IAllowanceMapper.class);

    Allowance toAllowance(final AllowanceRequestDto dto);
}
