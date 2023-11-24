package com.example.models.dtos.member;

import com.example.models.entities.Member;

public record MemberShortDTO(
        long id,
        String username,
        String email

) {
    public static MemberShortDTO fromEntity(Member member) {
        return new MemberShortDTO(
                member.getId(),
                member.getUsername(),
                member.getEmail());
    }
}
