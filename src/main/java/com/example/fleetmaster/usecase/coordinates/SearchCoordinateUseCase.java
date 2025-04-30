package com.example.fleetmaster.usecase.coordinates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fleetmaster.entity.coordinates.gateway.CoordinateGateway;
import com.example.fleetmaster.entity.coordinates.model.Coordinate;

@Service
public class SearchCoordinateUseCase {
    
    @Autowired
    private CoordinateGateway coordinateGateway;
    
    public List<Coordinate> execute() {
        return this.coordinateGateway.findAll();
    }
}
