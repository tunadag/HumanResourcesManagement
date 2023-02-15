package com.bilgeadam.dto.response;

import com.bilgeadam.repository.entity.LeaveType;
import com.bilgeadam.repository.entity.RequestState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LeaveResponseDto {
    private Long leaveId;
    private Long authId;
    private LeaveType leaveType;
    private String startDate;
    private String endDate;
    private String leaveRequestText;
    private String requestDate;
    private Long leaveDay;
    private RequestState requestState;
    private String replyDate;
}
