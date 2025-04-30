package com.example.fleetmaster.infrastructure.assignment.validation.Update;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.fleetmaster.infrastructure.assignment.dto.AssignmentUpdateData;
import com.example.fleetmaster.infrastructure.config.db.repository.AssignmentRepository;
import com.example.fleetmaster.infrastructure.config.db.repository.DriverRepository;
import com.example.fleetmaster.infrastructure.config.db.schema.AssignmentSchema;
import com.example.fleetmaster.infrastructure.config.db.schema.DriverSchema;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class DriverNotAssignedForUpdateValidator implements ConstraintValidator<DriverNotAssignedForUpdate, AssignmentUpdateData> {

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public boolean isValid(AssignmentUpdateData dto, ConstraintValidatorContext context) {
        if (dto.driverId() == null || dto.assignmentId() == null) return true;

        Optional<DriverSchema> driverOpt = driverRepository.findById(dto.driverId());
        if (driverOpt.isEmpty()) return true;

        DriverSchema driver = driverOpt.get();
        Optional<AssignmentSchema> existing = assignmentRepository.findByDriverAndActiveTrue(driver);

        if (existing.isPresent() && !existing.get().getId().equals(dto.assignmentId())) {
            context.disableDefaultConstraintViolation(); 
            context.buildConstraintViolationWithTemplate("Driver is already assigned to another vehicle")
                   .addPropertyNode("driverId") 
                   .addConstraintViolation(); 
            return false;
        }

        return true;
}
}
