package com.example.fleetmaster.infrastructure.route.validation.Register;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = AssignmentNotInUseValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface AssignmentNotInUse  {
    String message() default "This assignment is already in use by another route";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
