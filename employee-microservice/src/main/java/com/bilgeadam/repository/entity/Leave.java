package com.bilgeadam.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_leave")
public class Leave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long employeeId;
    @Enumerated(EnumType.STRING)
    private LeaveType leaveType;
    private Long startDate;
    private Long endDate;
    private String leaveRequestText;
    @Builder.Default
    private Long requestDate = System.currentTimeMillis();
    @Builder.Default
    private Long leaveDay = startDate - endDate;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private LeaveState leaveState = LeaveState.PENDING;
    @Builder.Default
    private Long replyDate = null;
}
