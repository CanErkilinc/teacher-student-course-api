package com.canerkilinc.api.entity;

import com.canerkilinc.api.entity.enums.Gender;
import com.canerkilinc.api.entity.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(name = "identity_no",length = 11,unique = true)
    private String identityNo;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "urole")
    @Enumerated(EnumType.STRING)
    private Role role;
}
