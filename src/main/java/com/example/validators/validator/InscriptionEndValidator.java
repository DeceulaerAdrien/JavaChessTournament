package com.example.validators.validator;

import com.example.models.forms.TournamentForm;
import com.example.validators.InscriptionEndDate;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class InscriptionEndValidator implements ConstraintValidator<InscriptionEndDate, TournamentForm> {
    @Override
    public void initialize(InscriptionEndDate constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(TournamentForm tournamentForm, ConstraintValidatorContext constraintValidatorContext) {
        if (tournamentForm == null)
            return true;

        LocalDate inscriptionDate = LocalDate.now();
        LocalDate formDate = tournamentForm.endInscriptionDate();
        int minParticipant = tournamentForm.minPlayers();

        LocalDate endDate = inscriptionDate.plusDays(minParticipant + 1);
        return formDate.isEqual(endDate) || formDate.isAfter(endDate);
    }
}
