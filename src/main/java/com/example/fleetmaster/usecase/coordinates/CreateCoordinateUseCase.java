package com.example.fleetmaster.usecase.coordinates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fleetmaster.entity.coordinates.model.Coordinate;
import com.example.fleetmaster.entity.coordinates.gateway.*;
import com.example.fleetmaster.usecase.coordinates.dto.ICoordinateRegistrationData;

@Service
public class CreateCoordinateUseCase {

    @Autowired
    private CoordinateGateway coordinateGateway;

    public Coordinate execute(ICoordinateRegistrationData data) {
        Coordinate coordinate = new Coordinate(data.latitude(), data.altitude(), data.name());

        return this.coordinateGateway.create(coordinate);
    }
}
