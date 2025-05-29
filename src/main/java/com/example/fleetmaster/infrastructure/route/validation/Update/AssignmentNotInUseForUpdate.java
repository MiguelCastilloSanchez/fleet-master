package com.example.fleetmaster.infrastructure.route.validation.Update;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AssignmentNotInUseForUpdateValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface AssignmentNotInUseForUpdate {
    String message() default "This assignment is already in use by another route";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}