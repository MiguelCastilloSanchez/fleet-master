package com.example.fleetmaster.infrastructure.route.validation.Update;

import com.example.fleetmaster.usecase.route.dto.IRouteUpdateData;
import com.example.fleetmaster.infrastructure.config.db.repository.RouteRepository;
import com.example.fleetmaster.infrastructure.config.db.schema.RouteSchema;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class AssignmentNotInUseForUpdateValidator implements ConstraintValidator<AssignmentNotInUseForUpdate, IRouteUpdateData> {

    @Autowired
    private RouteRepository routeRepository;

    @Override
    public boolean isValid(IRouteUpdateData dto, ConstraintValidatorContext context) {
        if (dto.assignmentId() == null) return true;

        Collection<RouteSchema> allRoutes = routeRepository.findAll();
        for (RouteSchema route : allRoutes) {
            if(dto.assignmentId().equals(route.getAssignment().getId())){
                return false;
            }
        }
        return true;
    }
}