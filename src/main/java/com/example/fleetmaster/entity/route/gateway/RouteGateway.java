package com.example.fleetmaster.entity.route.gateway;

import com.example.fleetmaster.entity.route.model.Route;

import java.util.List;
import java.util.Optional;

public interface RouteGateway {
    Route create(Route route);
    Route update(Route route);
    void delete(Long id);

    Optional<Route> findById(Long id);

    List<Route> findAll();
}
