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
public class LeaveRequestDto {
    private Long authId;
    private LeaveType leaveType;
    private String startDate;
    private String endDate;
    private String leaveRequestText;
}
