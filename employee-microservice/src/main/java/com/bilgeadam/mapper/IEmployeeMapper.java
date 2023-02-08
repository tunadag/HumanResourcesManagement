package com.bilgeadam.mapper;

import com.bilgeadam.dto.request.NewCreateEmployeeRequestDto;
import com.bilgeadam.dto.request.UpdateEmployeeRequestDto;
import com.bilgeadam.dto.response.UpdateEmployeeResponseDto;
import com.bilgeadam.repository.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface IEmployeeMapper {
    IEmployeeMapper INSTANCE = Mappers.getMapper(IEmployeeMapper.class);

    Employee toEmployee(final NewCreateEmployeeRequestDto dto);

    Employee toEmployee(final UpdateEmployeeRequestDto dto);

    UpdateEmployeeResponseDto toUpdateResponseDto(final UpdateEmployeeRequestDto dto);
    UpdateEmployeeResponseDto toUpdateResponseDto(final Employee employee);
}
