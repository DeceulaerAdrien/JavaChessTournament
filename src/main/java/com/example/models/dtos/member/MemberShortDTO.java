package com.example.models.dtos.member;

import com.example.models.entities.Member;

public record MemberShortDTO(

        long id,
        String username,
        String role,
        int elo
) {
    public static MemberShortDTO fromEntity(Member member) {
        return new MemberShortDTO(member.getId(),
                member.getUsername(),
                member.getRole(),
                member.getElo());
    }
}
