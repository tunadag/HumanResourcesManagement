package com.bilgeadam.dto.request;

import com.bilgeadam.repository.entity.LeaveType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateLeaveRequestDto {
    private Long employeeId;
    private LeaveType leaveType;
    private Long startDate;
    private Long endDate;
    private String leaveRequestText;
}
