package com.example.models.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Range;

import java.util.Date;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString(of = {"pseudo", "password", "email", "role"})
public class Member extends BaseEntity<Long> {


    @Column(name = "Member_Pseudonyme",
            length = 50,
            unique = true)
    @Getter
    @Setter
    private String pseudo;

    //Hasher pour la DB (securiter)
    @Column(name = "Member_Password")
    @Getter
    @Setter
    private String password;

    @Column(name = "Member_Email",
            length = 50,
            unique = true)
    @Getter
    @Setter
    private String email;

    @Column(name = "Member_Role",
            length = 50)
    @Getter
    @Setter
    private String role;

    @Column(name = "Member_Gender",
            length = 1)
    @Getter
    @Setter
    private char gender;

    @Column(name = "Member_BirthDate")
    @Getter
    @Setter
    private Date birthDate;

    @Column(name = "Member_Elo", columnDefinition = "int DEFAULT 1200")
    @Range(min = 0, max = 3000)
    @Getter
    @Setter
    private int elo;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Tournament> tournaments;
}