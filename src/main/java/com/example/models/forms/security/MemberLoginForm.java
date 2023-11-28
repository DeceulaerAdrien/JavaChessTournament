package com.example.models.forms.security;

import com.example.models.entities.Member;

public record MemberLoginForm(
        String username,

        String email,
        String password
) {
    public Member toEntity() {
        Member member = new Member();
        member.setUsername(this.username);
        member.setEmail(this.email);
        member.setPassword(this.password);
        return member;
    }
}
