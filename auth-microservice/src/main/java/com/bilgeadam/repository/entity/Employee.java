package com.bilgeadam.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
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
    String photo;
    String name;
    String secondName;
    String surname;
    Date birthOfDate;
    String placeOfBirth;
    Long nationalId;
    Date startDate;
    String occupation;
    String department;
    String address;
    String telephone;
    long createdDate;
    long updatedDate;
}
