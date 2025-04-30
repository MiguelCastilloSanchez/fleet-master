package com.example.fleetmaster.infrastructure.assignment.validation.Update;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = DriverNotAssignedForUpdateValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface DriverNotAssignedForUpdate {
    String message() default "Driver is already assigned to another vehicle";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

