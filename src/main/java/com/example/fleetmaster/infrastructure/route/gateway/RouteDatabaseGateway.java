package com.example.fleetmaster.infrastructure.route.gateway;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.fleetmaster.entity.coordinates.exception.CoordinateNotFoundException;
import com.example.fleetmaster.entity.route.exception.RouteNotFoundException;
import com.example.fleetmaster.entity.route.gateway.RouteGateway;
import com.example.fleetmaster.infrastructure.config.db.repository.AssignmentRepository;
import com.example.fleetmaster.infrastructure.config.db.repository.CoordinateRepository;
import com.example.fleetmaster.infrastructure.config.db.repository.RouteRepository;
import com.example.fleetmaster.infrastructure.config.db.schema.AssignmentSchema;
import com.example.fleetmaster.infrastructure.config.db.schema.CoordinateSchema;
import com.example.fleetmaster.infrastructure.config.db.schema.RouteSchema;
import com.example.fleetmaster.entity.route.model.Route;

@Component
public class RouteDatabaseGateway implements RouteGateway {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private CoordinateRepository coordinateRepository;

    @Override
    public Route create(Route route) {

        CoordinateSchema coordinateSchema = coordinateRepository.findById(route.getEndLocationId())
                .orElseThrow(CoordinateNotFoundException::new);

        AssignmentSchema assignmentSchema = assignmentRepository.findById(route.getAssignmentId())
                .orElseThrow(RouteNotFoundException::new);

        return this.routeRepository.save(new RouteSchema(
                route.getId(),
                route.getName(),
                route.getTravelDate(),
                coordinateSchema,
                assignmentSchema)).toRoute();
    }

    @Override
    public Route update(Route route) {
        RouteSchema schema = this.routeRepository.findById(route.getId()).orElseThrow(RouteNotFoundException::new);
        schema.updateRoute(route);
        return this.routeRepository.save(schema).toRoute();
    }

    @Override
    public void delete(Long id) {
        this.routeRepository.deleteById(id);
    }

    @Override
    public Optional<Route> findById(Long id) {
        return this.routeRepository
                .findById(id)
                .map(RouteSchema::toRoute);
    }

    @Override
    public List<Route> findAll() {
        return routeRepository
                .findAll()
                .stream()
                .map(RouteSchema::toRoute)
                .toList();
    }

}
