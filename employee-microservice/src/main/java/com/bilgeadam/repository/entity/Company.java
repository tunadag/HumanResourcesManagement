package com.bilgeadam.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Company implements Serializable {
    @Id
    private String id;
    private String name;
    @Indexed(unique = true)
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
