package com.example.models.forms;

import com.example.models.entities.Member;
import com.example.models.entities.enums.MemberGenderEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


import java.time.LocalDate;

public record MemberForm(
        @NotBlank
        @Size(min = 2, max = 50)
        String userName,

        @NotBlank
        @Size(max = 50)
        String eMail,

        @NotBlank
        String role,

        @NotBlank
        @Size(min = 8, max = 15)
        String password,

        MemberGenderEnum gender,


        LocalDate birthDate,

        int elo
) {
    public Member toEntity() {
        Member member = new Member();
        member.setUsername(this.userName);
        member.setPassword(this.password);
        member.setEmail(this.eMail);
        member.setRole(this.role);
        member.setGender(this.gender);
        member.setBirthDate(this.birthDate);
        member.setElo(this.elo);
        return member;
    }
}