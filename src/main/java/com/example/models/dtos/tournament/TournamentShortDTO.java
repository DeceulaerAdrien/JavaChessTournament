package com.example.models.dtos.tournament;

import com.example.models.dtos.member.MemberShortDTO;
import com.example.models.entities.Tournament;

import java.util.Set;
import java.util.stream.Collectors;

public record TournamentShortDTO(
        Long id,

        String name,

        Set<MemberShortDTO> memberShortDTOSet

) {
    public static TournamentShortDTO fromEntity(Tournament tournament) {

        Set<MemberShortDTO> memberShortDTOS = tournament.getMemberSet().stream()
                .map(MemberShortDTO::fromEntity).collect(Collectors.toSet());

        return new TournamentShortDTO(tournament.getId(), tournament.getName(), memberShortDTOS);
    }
}
