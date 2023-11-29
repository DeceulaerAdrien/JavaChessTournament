package com.example.models.dtos.encounter;

import com.example.models.dtos.member.MemberShortDTO;
import com.example.models.entities.Encounter;
import com.example.models.entities.Member;
import com.example.models.entities.enums.EncounterResultEnum;

public record EncounterDTO(
        Member joueuBlanc,

        Member joueuNoir,

        int number_round,

        EncounterResultEnum resultEnum

) {

    public static EncounterDTO fromEntity(Encounter encounter){
        return new EncounterDTO(
                encounter.getJoueurBlanc(),
                encounter.getJoueurNoir(),
                encounter.getNumber_round(),
                encounter.getResultEnum());
    }
}
