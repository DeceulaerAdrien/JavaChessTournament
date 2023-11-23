package com.example.models.dtos.tournament;

import com.example.models.entities.Tournament;
import lombok.*;

import java.time.LocalDate;

public record TournamentDTO(
        Long id,
        String name,
        String location,
        String statut,
        LocalDate endInscriptionDate,
        int minElo,
        int maxElo,
        boolean womenOnly
) {

    public static TournamentDTO fromEntity(Tournament tournament) {
        return new TournamentDTO(
                tournament.getId(),
                tournament.getName(),
                tournament.getLocation(),
                tournament.getStatut(),
                tournament.getEndInscritpionDate(),
                tournament.getMinElo(),
                tournament.getMaxElo(),
                tournament.isWomenOnly()
        );
    }
}