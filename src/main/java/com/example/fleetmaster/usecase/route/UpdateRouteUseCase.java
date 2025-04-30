package com.example.fleetmaster.usecase.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fleetmaster.entity.route.exception.RouteNotFoundException;
import com.example.fleetmaster.entity.route.gateway.RouteGateway;
import com.example.fleetmaster.entity.route.model.Route;
import com.example.fleetmaster.infrastructure.config.db.repository.AssignmentRepository;
import com.example.fleetmaster.infrastructure.config.db.schema.AssignmentSchema;
import com.example.fleetmaster.usecase.route.dto.IRouteUpdateData;

@Service
public class UpdateRouteUseCase {

    @Autowired
    private RouteGateway routeGateway;

    @Autowired
    private AssignmentRepository assignmentRepository;

    public Route execute(Long id, IRouteUpdateData data) throws RouteNotFoundException {
        Route route = this.routeGateway.findById(id).orElseThrow(RouteNotFoundException::new);

        if (data.name() != null && !data.name().isBlank()) {
            route.setName(data.name());
        }

        if (data.travelDate() != null) {
            route.setTravelDate(data.travelDate());
        }

        if (data.endLocationId() != null) {
            route.setEndLocationId(data.endLocationId());
        }

        if (data.assignmentId() != null) {
            AssignmentSchema assignmentSchema = assignmentRepository.findById(data.assignmentId())
                    .orElseThrow(RouteNotFoundException::new);
            route.setAssignment(assignmentSchema);
        }

        if (data.isSuccessfulRoute()) {
            route.setSuccessfulRoute(data.isSuccessfulRoute());
        }

        if (data.problemdescription() != null && !data.problemdescription().isBlank()) {
            route.setProblemdescription(data.problemdescription());
        } else {
            route.setProblemdescription(" ");
        }

        if (data.commentaries() != null && !data.commentaries().isEmpty()) {
            route.addCommentary(data.commentaries().get(0));
        }

        return this.routeGateway.update(route);
    }
}
