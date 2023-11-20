package com.example.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Member_Id")
    private long id;

    @Column(name = "Member_Pseudonyme",
            length = 50)
    private String pseudo;

    @Column(name = "Member_Password")
    private String password;

    @Column(name = "Member_Email",
            length = 50)
    private String email;

    @Column(name = "Member_Role",
            length = 50)
    private String role;

    @Column(name = "Member_Gender",
            length = 50)
    private char gender;

    @Column(name = "Member_BirthDate",
            length = 1)
    private Date birthDate;

    @Column(name = "Member_Elo",columnDefinition = "int DEFAULT 1200")
    private int elo;

}
