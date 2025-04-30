package com.example.fleetmaster.infrastructure.assignment.validation.Register;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = DriverNotAssignedValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface DriverNotAssigned {
    String message() default "Driver is already assigned to a vehicle";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
