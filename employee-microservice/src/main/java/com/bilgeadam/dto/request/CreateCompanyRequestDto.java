package com.bilgeadam.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateCompanyRequestDto {
    private String name;
    private String companyName;
    private Long mersisNo;
    private Long taxNumber;
    private String taxOffice;
    private String logo;
    private String phone;
    private String address;
    @Email
    private String email;
    private int employeeNumber;
    private int foundationYear;
    private Long contractStartDate;
    private Long contractEndDate;
}
