package com.bilgeadam.dto.response;

import com.bilgeadam.repository.entity.LeaveState;
import com.bilgeadam.repository.entity.LeaveType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateLeaveResponseDto {
    private Long id;
    private Long employeeId;
    private LeaveType leaveType;
    private Long startDate;
    private Long endDate;
    private String leaveRequestText;
    private Long requestDate;
    private Long leaveDay;
    private LeaveState leaveState;
    private Long replyDate;
}