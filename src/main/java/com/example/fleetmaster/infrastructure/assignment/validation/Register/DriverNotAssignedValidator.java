package com.example.fleetmaster.infrastructure.assignment.validation.Register;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.fleetmaster.infrastructure.config.db.repository.AssignmentRepository;
import com.example.fleetmaster.infrastructure.config.db.repository.DriverRepository;
import com.example.fleetmaster.infrastructure.config.db.schema.DriverSchema;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class DriverNotAssignedValidator implements ConstraintValidator<DriverNotAssigned, Long> {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Override
    public boolean isValid(Long driverId, ConstraintValidatorContext context) {
        if (driverId == null) return true;
        Optional<DriverSchema> driverOpt = driverRepository.findById(driverId);
        if (driverOpt.isEmpty()) return true;

        return assignmentRepository.findByDriverAndActiveTrue(driverOpt.get()).isEmpty();
    }
}
