package com.bilgeadam.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tbl_auth")
@Entity
public class Auth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Roles roles = Roles.PERSONAL;
    /*
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
    */
}
