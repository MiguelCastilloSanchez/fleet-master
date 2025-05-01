package com.example.fleetmaster.usecase.route;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fleetmaster.entity.route.gateway.RouteGateway;
import com.example.fleetmaster.entity.route.model.Route;

@Service
public class SearchRouteUseCase {
    
    @Autowired
    private RouteGateway routeGateway;
    
    public List<Route> execute() {
        return this.routeGateway.findAll();
    }
}
