package com.example.fleetmaster.infrastructure.route.validation.Register;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.fleetmaster.infrastructure.config.db.repository.RouteRepository;
import com.example.fleetmaster.infrastructure.config.db.schema.RouteSchema;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class AssignmentNotInUseValidator implements ConstraintValidator<AssignmentNotInUse, Long> {
    @Autowired
    private RouteRepository routeRepository;

    @Override
    public boolean isValid(Long assignmentId, ConstraintValidatorContext context) {
        if (assignmentId == null)
            return true;

        Collection<RouteSchema> rouOptional = routeRepository.findAll();
        for (RouteSchema routeSchema : rouOptional) {
            if (assignmentId.equals(routeSchema.getAssignment().getId())) {
                return false;
            }
        }
        return true;
    }
}
