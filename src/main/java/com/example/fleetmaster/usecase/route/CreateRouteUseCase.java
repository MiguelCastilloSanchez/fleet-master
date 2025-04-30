package com.example.fleetmaster.usecase.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fleetmaster.entity.route.gateway.RouteGateway;
import com.example.fleetmaster.entity.route.model.Route;
import com.example.fleetmaster.usecase.route.dto.IRouteRegistrationData;

@Service
public class CreateRouteUseCase {
    
    @Autowired
    private RouteGateway routeGateway;
    
    public Route execute(IRouteRegistrationData data) {
        Route route = new Route(data.name(), data.travelDate(), data.endLocation(), data.assignmentId());
        return this.routeGateway.create(route);
    }
}
