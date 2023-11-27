package com.example.validators;

import com.example.validators.validator.MinMaxEloValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MinMaxEloValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MinMaxElo {
    String message() default "Le Elo minimum doit être inférieur ou égal au Elo maximum du tournoi !";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
