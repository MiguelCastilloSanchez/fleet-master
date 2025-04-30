package com.example.fleetmaster.infrastructure.coordinates.dto;

import com.example.fleetmaster.entity.coordinates.model.Coordinate;
import com.example.fleetmaster.usecase.coordinates.dto.ICoordinatePublicData;

public record CoordinatePublicData(
        String id,
        double latitude,
        double altitude,
        String name) implements ICoordinatePublicData {
    public CoordinatePublicData(Coordinate coordinate) {
        this(
                coordinate.getId().toString(),
                coordinate.getLatitude(),
                coordinate.getAltitude(),
                coordinate.getName());
    }

}
