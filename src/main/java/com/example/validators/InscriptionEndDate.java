package com.example.validators;

import com.example.validators.validator.InscriptionEndValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = InscriptionEndValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface InscriptionEndDate {
    String message() default "La date de fin d'inscription doit au minimum être égal a nombre de joueur + 1 jour !";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
