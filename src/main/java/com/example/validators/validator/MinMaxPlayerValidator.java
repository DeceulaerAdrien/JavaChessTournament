package com.example.validators.validator;

import com.example.models.forms.TournamentForm;
import com.example.validators.MinMaxPlayer;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MinMaxPlayerValidator implements ConstraintValidator<MinMaxPlayer, TournamentForm> {
    @Override
    public void initialize(MinMaxPlayer constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(TournamentForm tournamentForm, ConstraintValidatorContext constraintValidatorContext) {
        if (tournamentForm == null)
            return true;

        int minPlayers = tournamentForm.minPlayers();
        int maxPlayers = tournamentForm.maxPlayers();

        return maxPlayers >= minPlayers;
    }
}
