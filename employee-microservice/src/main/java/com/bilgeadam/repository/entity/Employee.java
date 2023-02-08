package com.bilgeadam.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Employee implements Serializable {
    @Id
    private String id;
    @Indexed(unique = true)
    private Long authId;
    @Indexed(unique = true)
    private String email;
    private String password;
    private String photo;
    private String name;
    private String secondName;
    private String surname;
    private Date birthOfDate;
    private String placeOfBirth;
    private Long nationalId;
    private Date startDate;
    private String occupation;
    private String department;
    private String address;
    private String telephone;
    private Roles role;
    private String companyId;
    private Long createdDate;
    private Long updatedDate;
}
