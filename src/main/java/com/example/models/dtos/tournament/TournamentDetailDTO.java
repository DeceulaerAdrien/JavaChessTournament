package com.example.models.dtos.tournament;

import com.example.models.dtos.member.MemberShortDTO;
import com.example.models.entities.Tournament;
import com.example.models.entities.enums.TournamentStatutEnum;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

public record TournamentDetailDTO(
        Long id,
        String name,
        String location,
        TournamentStatutEnum statut,
        LocalDate endInscriptionDate,
        int maxPlayer,
        int minPlayer,
        int minElo,
        int maxElo,
        int round,
        int playerCount,
        boolean womenOnly,
        Set<MemberShortDTO> memberSet
) {

    public static TournamentDetailDTO fromEntity(Tournament tournament) {

        Set<MemberShortDTO> memberSet = tournament.getMemberSet().stream()
                .map(MemberShortDTO::fromEntity).collect(Collectors.toSet());

        int playerCount = tournament.getMemberSet().size();

        return new TournamentDetailDTO(
                tournament.getId(),
                tournament.getName(),
                tournament.getLocation(),
                tournament.getStatut(),
                tournament.getEndInscritpionDate(),
                tournament.getMinPlayer(),
                tournament.getMaxPlayer(),
                tournament.getMinElo(),
                tournament.getMaxElo(),
                tournament.getRound(),
                playerCount,
                tournament.isWomenOnly(),
                memberSet
        );
    }
}
