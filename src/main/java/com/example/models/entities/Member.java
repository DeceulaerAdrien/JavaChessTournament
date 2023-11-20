package com.example.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;
import org.hibernate.engine.jdbc.Size;
import org.hibernate.validator.constraints.Range;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString(of = {"pseudo", "password", "email", "role"})
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Member_Id")
    private long id;

    @Column(name = "Member_Pseudonyme",
            length = 50,
            unique = true)
    private String pseudo;

    //Hasher pour la DB (securiter)
    @Column(name = "Member_Password")
    private String password;

    @Column(name = "Member_Email",
            length = 50,
            unique = true)
    private String email;

    @Column(name = "Member_Role",
            length = 50)
    private String role;

    @Column(name = "Member_Gender",
            length = 1)
    private char gender;

    @Column(name = "Member_BirthDate")
    private Date birthDate;

    @Column(name = "Member_Elo", columnDefinition = "int DEFAULT 1200")
    @Range(min = 0, max = 3000)
    private int elo;


}
