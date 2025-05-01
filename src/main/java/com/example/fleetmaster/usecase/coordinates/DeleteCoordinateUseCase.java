package com.example.fleetmaster.usecase.coordinates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fleetmaster.entity.coordinates.exception.CoordinateNotFoundException;
import com.example.fleetmaster.entity.coordinates.gateway.CoordinateGateway;
import com.example.fleetmaster.entity.coordinates.model.Coordinate;

@Service
public class DeleteCoordinateUseCase {

    @Autowired
    private CoordinateGateway coordinateGateway;

    public Coordinate execute(Long id) {
        Coordinate coordinate = this.coordinateGateway.findById(id).orElseThrow(CoordinateNotFoundException::new);

        this.coordinateGateway.delete(id);

        return coordinate;
    }
}
