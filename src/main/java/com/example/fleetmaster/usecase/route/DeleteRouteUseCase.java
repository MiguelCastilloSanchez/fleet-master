package com.example.fleetmaster.usecase.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fleetmaster.entity.route.exception.RouteNotFoundException;
import com.example.fleetmaster.entity.route.gateway.RouteGateway;
import com.example.fleetmaster.entity.route.model.Route;

@Service
public class DeleteRouteUseCase {

    @Autowired
    private RouteGateway routeGateway;

    public Route execute(Long id) throws RouteNotFoundException {
        Route route = this.routeGateway.findById(id).orElseThrow(RouteNotFoundException::new);

        this.routeGateway.delete(id);

        return route;
    }
}
