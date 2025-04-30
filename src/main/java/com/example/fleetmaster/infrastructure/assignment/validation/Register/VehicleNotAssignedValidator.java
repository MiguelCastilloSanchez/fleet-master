package com.example.fleetmaster.infrastructure.assignment.validation.Register;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.fleetmaster.infrastructure.config.db.repository.AssignmentRepository;
import com.example.fleetmaster.infrastructure.config.db.repository.VehicleRepository;
import com.example.fleetmaster.infrastructure.config.db.schema.VehicleSchema;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class VehicleNotAssignedValidator implements ConstraintValidator<VehicleNotAssigned, Long> {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Override
    public boolean isValid(Long vehicleId, ConstraintValidatorContext context) {
        if (vehicleId == null) return true;
        Optional<VehicleSchema> vehicleOpt = vehicleRepository.findById(vehicleId);
        if (vehicleOpt.isEmpty()) return true;

        return assignmentRepository.findByVehicleAndActiveTrue(vehicleOpt.get()).isEmpty();
    }
}
