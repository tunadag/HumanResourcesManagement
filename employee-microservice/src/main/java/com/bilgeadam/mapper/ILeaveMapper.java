package com.bilgeadam.mapper;

import com.bilgeadam.dto.request.LeaveRequestDto;
import com.bilgeadam.dto.response.LeaveResponseDto;
import com.bilgeadam.repository.entity.Leave;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ILeaveMapper {
    ILeaveMapper INSTANCE = Mappers.getMapper(ILeaveMapper.class);

    Leave toLeave(final LeaveRequestDto dto);
    List<Leave> toLeaves(final List<Leave> leaves);
    LeaveResponseDto toCreateLeaveResponseDto(final Leave leave);
}
