package com.example.models.forms;

import com.example.models.entities.Encounter;
import com.example.models.entities.Member;
import com.example.models.entities.enums.EncounterResultEnum;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Setter;

public record EncounterForm(
        @NotBlank
        Member joueurBlanc,

        @NotBlank
        Member joueurNoir,

        @NotNull
        int number_round,

        EncounterResultEnum resultEnum
) {
    public Encounter toEntity(){
        Encounter encounter = new Encounter();
        encounter.setJoueurBlanc(this.joueurBlanc);
        encounter.setJoueurNoir(this.joueurNoir);
        encounter.setNumber_round(this.number_round);
        encounter.setResultEnum(this.resultEnum);
        return encounter;
    }
}