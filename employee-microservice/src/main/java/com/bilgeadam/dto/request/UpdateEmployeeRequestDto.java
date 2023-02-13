package com.bilgeadam.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateEmployeeRequestDto implements Serializable {
    String token;
    String department;
    String address;
    String telephone;
    String surname;
    String photo;
    Long directorId;
}
