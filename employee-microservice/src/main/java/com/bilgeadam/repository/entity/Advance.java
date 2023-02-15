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
@Table
@Entity
public class Advance extends Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long advanceId;
    private Double amount;
    private String currency;

}
