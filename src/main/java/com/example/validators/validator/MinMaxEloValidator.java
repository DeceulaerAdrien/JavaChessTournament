package com.example.validators.validator;

import com.example.models.forms.TournamentForm;
import com.example.validators.MinMaxElo;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MinMaxEloValidator implements ConstraintValidator<MinMaxElo, TournamentForm> {
    @Override
    public void initialize(MinMaxElo constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(TournamentForm tournamentForm, ConstraintValidatorContext constraintValidatorContext) {
        if (tournamentForm == null)
            return true;
        int minPlayers = tournamentForm.minElo();
        int maxPlayers = tournamentForm.maxElo();

        return maxPlayers >= minPlayers;
    }
}
