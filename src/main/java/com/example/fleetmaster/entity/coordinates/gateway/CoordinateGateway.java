package com.example.fleetmaster.entity.coordinates.gateway;

import com.example.fleetmaster.entity.coordinates.model.Coordinate;

import java.util.List;
import java.util.Optional;

public interface CoordinateGateway {
    Coordinate create(Coordinate route);
    void delete(Long id);

    Optional<Coordinate> findById(Long id);

    List<Coordinate> findAll();
}
