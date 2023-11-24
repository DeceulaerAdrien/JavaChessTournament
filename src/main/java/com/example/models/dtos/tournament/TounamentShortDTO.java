package com.example.models.dtos.tournament;

import com.example.models.dtos.member.MemberShortDTO;
import com.example.models.entities.Tournament;

import java.util.Set;
import java.util.stream.Collectors;

public record TounamentShortDTO(
        Long id,

        String name,

        Set<MemberShortDTO> memberShortDTOSet

) {
    public static TounamentShortDTO fromEntity(Tournament tournament){
        Set<MemberShortDTO> memberShortDTOS = tournament.getListparticipant().stream()
                .map(MemberShortDTO :: fromEntity).collect(Collectors.toSet());
        return new TounamentShortDTO(tournament.getId(),tournament.getName(),memberShortDTOS);
    }
}
