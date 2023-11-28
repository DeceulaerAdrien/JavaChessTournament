package com.example.models.dtos.tournament;

import com.example.models.entities.Tournament;
import com.example.models.entities.enums.TournamentCategorieEnum;
import com.example.models.entities.enums.TournamentStatutEnum;

import java.time.LocalDate;
import java.util.Set;


public record TournamentDTO(
        Long id,
        String name,
        String location,
        Set<TournamentCategorieEnum> categorieEnumSet,
        TournamentStatutEnum statut,
        LocalDate endInscriptionDate,
        int maxPlayer,
        int minPlayer,
        int minElo,
        int maxElo,
        int round,
        int playerCount,
        boolean womenOnly
) {

    public static TournamentDTO fromEntity(Tournament tournament) {


        int playerCount = tournament.getMemberSet().size();

        return new TournamentDTO(
                tournament.getId(),
                tournament.getName(),
                tournament.getLocation(),
                tournament.getCategorie(),
                tournament.getStatut(),
                tournament.getEndInscritpionDate(),
                tournament.getMinPlayer(),
                tournament.getMaxPlayer(),
                tournament.getMinElo(),
                tournament.getMaxElo(),
                tournament.getRound(),
                playerCount,
                tournament.isWomenOnly()
        );
    }
}