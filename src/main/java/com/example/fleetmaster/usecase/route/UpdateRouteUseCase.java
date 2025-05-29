package com.example.fleetmaster.usecase.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fleetmaster.entity.assigment.exception.AssignmentNotFoundException;
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
            System.out.println("UpdateRouteUseCase ID_LOCATION: " + data.endLocationId());
            route.setEndLocationId(data.endLocationId());
        }

        if (data.assignmentId() != null) {
            AssignmentSchema assignmentSchema = assignmentRepository.findById(data.assignmentId())
                    .orElseThrow(AssignmentNotFoundException::new);

                    

            route.setAssignment(assignmentSchema);
        }

        if (data.isSuccessfulRoute() != null) {
            route.setSuccessfulRoute(Boolean.parseBoolean(data.isSuccessfulRoute()));
        }

        if (data.problemdescription() != null) {
            route.setProblemdescription(data.problemdescription());
        }

        if (data.commentaries() != null && !data.commentaries().isBlank()) {
            route.addCommentary(data.commentaries());
        }

        System.out.println("UpdtRoutUsCas: idAsing: " + route.getAssignmentId());

        return this.routeGateway.update(route);
    }
}
