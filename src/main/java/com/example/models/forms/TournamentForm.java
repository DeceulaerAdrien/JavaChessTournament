package com.example.models.forms;

import com.example.models.entities.Tournament;

import com.example.models.entities.enums.TournamentCategoriesEnum;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString @EqualsAndHashCode
public class TournamentForm {
    @NotBlank
    @Length(max = 100)
    private String name;
    @NotBlank
    @Length(max = 100)
    private String location;
    @NotBlank
    private TournamentCategoriesEnum categoriesEnum;
    @NotBlank
    private String statut;
    @NotBlank
    @Range(min = 2, max = 32)
    private Integer minPlayers;
    @NotBlank
    @Range(min = 2, max = 32)
    private Integer maxPlayers;
    @NotBlank
    @Range(min = 0, max = 3000)
    private int minElo;
    @NotBlank
    @Range(min = 0, max = 3000)
    private int maxElo;

    @NotNull
    private boolean womenOnly;
    @NotNull

    private LocalDateTime endInscriptionDate;


    public Tournament toEntity() {

        return new Tournament(
                this.name,
                this.location,
                this.categoriesEnum,
                this.statut,
                this.minPlayers,
                this.maxPlayers,
                this.minElo,
                this.maxElo,
                this.womenOnly,
                this.endInscriptionDate);


    }

}





