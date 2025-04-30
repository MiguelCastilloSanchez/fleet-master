package com.example.fleetmaster.infrastructure.assignment.validation.Update;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.fleetmaster.infrastructure.assignment.dto.AssignmentUpdateData;
import com.example.fleetmaster.infrastructure.config.db.repository.AssignmentRepository;
import com.example.fleetmaster.infrastructure.config.db.repository.VehicleRepository;
import com.example.fleetmaster.infrastructure.config.db.schema.AssignmentSchema;
import com.example.fleetmaster.infrastructure.config.db.schema.VehicleSchema;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class VehicleNotAssignedForUpdateValidator implements ConstraintValidator<VehicleNotAssignedForUpdate, AssignmentUpdateData> {

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public boolean isValid(AssignmentUpdateData dto, ConstraintValidatorContext context) {
      if (dto.vehicleId() == null || dto.assignmentId() == null) return true;

        Optional<VehicleSchema> vehicleOpt = vehicleRepository.findById(dto.vehicleId());
        if (vehicleOpt.isEmpty()) return true;

        VehicleSchema vehicle = vehicleOpt.get();
        Optional<AssignmentSchema> existing = assignmentRepository.findByVehicleAndActiveTrue(vehicle);

        if (existing.isPresent() && !existing.get().getId().equals(dto.assignmentId())) {
            context.disableDefaultConstraintViolation(); 
            context.buildConstraintViolationWithTemplate("Vehicle is already assigned to another vehicle")
                   .addPropertyNode("vehicleId") 
                   .addConstraintViolation(); 
            return false;
        }

        return true;
    }
}
