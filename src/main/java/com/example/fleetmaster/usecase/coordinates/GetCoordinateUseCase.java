package com.example.fleetmaster.usecase.coordinates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fleetmaster.entity.coordinates.exception.CoordinateNotFoundException;
import com.example.fleetmaster.entity.coordinates.gateway.CoordinateGateway;
import com.example.fleetmaster.entity.coordinates.model.Coordinate;
import com.example.fleetmaster.entity.route.exception.RouteNotFoundException;

@Service
public class GetCoordinateUseCase {

    @Autowired
    private CoordinateGateway coordinateGateway;

    public Coordinate execute(Long id) throws RouteNotFoundException {
        return this.coordinateGateway.findById(id).orElseThrow(CoordinateNotFoundException::new);
    }
}
