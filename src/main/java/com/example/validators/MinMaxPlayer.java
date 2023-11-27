package com.example.validators;

import com.example.validators.validator.MinMaxPlayerValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MinMaxPlayerValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MinMaxPlayer {
    String message() default "Le nombre de joueurs maximum doit être supérieur ou égal au nombre minimum de joueurs du tournoi !";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
