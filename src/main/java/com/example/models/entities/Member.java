package com.example.models.entities;

import com.example.models.entities.enums.MemberGenderEnum;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Range;

import java.util.Date;

@Getter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(of = {"username", "password", "email", "role"})
public class Member extends BaseEntity<Long> {

    @Column(name = "Member_Username",
            length = 50,
            unique = true)
    @Setter
    private String username;

    //Hasher pour la DB (security)
    @Column(name = "Member_Password")
    @Setter
    private String password;

    @Column(name = "Member_Email",
            length = 50,
            unique = true)
    @Setter
    private String email;

    @Column(name = "Member_Role",
            length = 50)
    @Setter
    private String role;

    @Column(name = "Member_Gender",
            length = 10 )
    @Enumerated(EnumType.STRING)
    @Setter
    private MemberGenderEnum gender;

    @Column(name = "Member_Birth_Date")
    @Setter
    private Date birthDate;

    @Column(name = "Member_Elo", columnDefinition = "int DEFAULT 1200")
    @Range(min = 0, max = 3000)
    @Setter
    private int elo;
}