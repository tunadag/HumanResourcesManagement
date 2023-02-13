package com.bilgeadam.mapper;

import com.bilgeadam.dto.request.CreateLeaveRequestDto;
import com.bilgeadam.dto.response.CreateLeaveResponseDto;
import com.bilgeadam.repository.entity.Leave;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ILeaveMapper {
    ILeaveMapper INSTANCE = Mappers.getMapper(ILeaveMapper.class);

    Leave toLeave(final CreateLeaveRequestDto dto);
    List<Leave> toLeaves(final List<Leave> leaves);
    CreateLeaveResponseDto toCreateLeaveResponseDto(final Leave leave);
}
