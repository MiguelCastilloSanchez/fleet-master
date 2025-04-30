package com.example.fleetmaster.usecase.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fleetmaster.entity.route.exception.RouteNotFoundException;
import com.example.fleetmaster.entity.route.gateway.RouteGateway;
import com.example.fleetmaster.entity.route.model.Route;
import com.example.fleetmaster.usecase.route.dto.IRouteUpdateData;

@Service
public class UpdateRouteUseCase {

    @Autowired
    private RouteGateway routeGateway;

    public Route execute(Long id, IRouteUpdateData data) throws RouteNotFoundException {
        Route route = this.routeGateway.findById(id).orElseThrow(RouteNotFoundException::new);

        if (data.name() != null && !data.name().isBlank()) {
            route.setName(data.name());
        }

        if (data.travelDate() != null) {
            route.setTravelDate(data.travelDate());
        }

        if (data.endLocation() != null) {
            route.setEndLocation(data.endLocation());
        }

        if (data.assignmentId() != null) {
            route.setAssignmentId(data.assignmentId());
        }

        if (data.isSuccessfulRoute()) {
            route.setSuccessfulRoute(data.isSuccessfulRoute());
        }

        if (data.problemdescription() != null && !data.problemdescription().isBlank()) {
            route.setProblemdescription(data.problemdescription());
        }

        // this is precaryous, we have to check how adding a new commentary.
        if (data.commentaries() != null && !data.commentaries().isEmpty()) {
            route.addCommentary(data.commentaries().get(0)); //  a list of objects with a description, and user?
        }

        return this.routeGateway.update(route);
    }
}
