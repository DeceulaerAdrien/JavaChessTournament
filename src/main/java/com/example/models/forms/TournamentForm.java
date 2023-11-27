package com.example.models.forms;

import com.example.models.entities.Tournament;

import com.example.models.entities.enums.TournamentCategorieEnum;

import com.example.models.entities.enums.TournamentStatutEnum;
import com.example.validators.InscriptionEndDate;
import com.example.validators.MinMaxElo;
import com.example.validators.MinMaxPlayer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;

@MinMaxPlayer
@MinMaxElo
@InscriptionEndDate
public record TournamentForm(
        @NotBlank
        @Size(max = 50)
        String name,

        @NotBlank
        @Size(max = 100)
        String location,

        @NotNull
        TournamentCategorieEnum categoriesEnum,
        TournamentStatutEnum statut,

        @NotNull
        @Range(min = 2, max = 32)
        int minPlayers,

        @NotNull
        @Range(min = 2, max = 32)
        int maxPlayers,

        @NotNull
        @Range(min = 0, max = 3000)
        int minElo,

        @NotNull
        @Range(min = 0, max = 3000)
        int maxElo,

        @NotNull
        boolean womenOnly,

        @NotNull
        LocalDate endInscriptionDate
) {
    public Tournament toEntity() {
        Tournament tournament = new Tournament();
        tournament.setName(this.name);
        tournament.setLocation(this.location);
        tournament.setCategorie(this.categoriesEnum);
        tournament.setStatut(this.statut);
        tournament.setMinPlayer(this.minPlayers);
        tournament.setMaxPlayer(this.maxPlayers);
        tournament.setMinElo(this.minElo);
        tournament.setMaxElo(this.maxElo);
        tournament.setWomenOnly(this.womenOnly);
        tournament.setEndInscritpionDate(this.endInscriptionDate);
        return tournament;
    }

//    public static TournamentForm fromEntity(Tournament tournament) {
//        return new TournamentForm(
//                tournament.getName(),
//                tournament.getLocation(),
//                tournament.getCategorie(),
//                tournament.getStatut(),
//                tournament.getMinPlayer(),
//                tournament.getMaxPlayer(),
//                tournament.getMinElo(),
//                tournament.getMaxElo(),
//                tournament.isWomenOnly(),
//                tournament.getEndInscritpionDate()
//        );
//    }
}





