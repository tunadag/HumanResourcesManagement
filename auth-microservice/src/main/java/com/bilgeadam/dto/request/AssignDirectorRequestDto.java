package com.bilgeadam.dto.request;

import com.bilgeadam.repository.entity.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssignDirectorRequestDto {
    String email;
    Roles role;
}
