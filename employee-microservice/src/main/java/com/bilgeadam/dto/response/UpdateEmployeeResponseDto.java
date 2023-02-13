package com.bilgeadam.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateEmployeeResponseDto {
    String department;
    String address;
    String telephone;
    String surname;
    String photo;
    Long directorId;
    Long updatedDate;
}
