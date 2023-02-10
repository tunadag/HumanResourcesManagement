package com.bilgeadam.rabbitmq.model;

import com.bilgeadam.repository.entity.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssignDirector implements Serializable {
    String email;
    Roles role;
}
