package com.example.fleetmaster.usecase.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fleetmaster.entity.route.exception.InactiveAssignmentException;
import com.example.fleetmaster.entity.route.exception.RouteNotFoundException;
import com.example.fleetmaster.entity.route.gateway.RouteGateway;
import com.example.fleetmaster.entity.route.model.Route;
import com.example.fleetmaster.infrastructure.config.db.repository.AssignmentRepository;
import com.example.fleetmaster.infrastructure.config.db.schema.AssignmentSchema;
import com.example.fleetmaster.usecase.route.dto.IRouteRegistrationData;

@Service
public class CreateRouteUseCase {

    @Autowired
    private RouteGateway routeGateway;

    @Autowired
    private AssignmentRepository assignmentRepository;

    public Route execute(IRouteRegistrationData data) {

        AssignmentSchema assignmentSchema = assignmentRepository.findById(data.assignmentId())
                .orElseThrow(RouteNotFoundException::new);

        if (!assignmentSchema.isActive()) {
            throw new InactiveAssignmentException("Assignment is  inactive");
        }

        Route route = new Route(data.name(), data.travelDate(), data.endLocationId(), assignmentSchema);
        return this.routeGateway.create(route);
    }
}
