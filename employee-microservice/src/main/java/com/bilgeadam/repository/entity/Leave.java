package com.bilgeadam.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "tbl_leave")
public class Leave extends Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leaveId;
    private Long authId;
    @Enumerated(EnumType.STRING)
    private LeaveType leaveType;
    private String startDate;
    private String endDate;
    private String leaveRequestText;
    private Long leaveDay;
}
