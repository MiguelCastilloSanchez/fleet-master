package com.example.fleetmaster.infrastructure.coordinates.gateway;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.fleetmaster.entity.coordinates.gateway.CoordinateGateway;
import com.example.fleetmaster.entity.coordinates.model.Coordinate;
import com.example.fleetmaster.infrastructure.config.db.repository.CoordinateRepository;
import com.example.fleetmaster.infrastructure.config.db.schema.CoordinateSchema;

@Component
public class CoordinateDatabaseGateway implements CoordinateGateway {

    @Autowired
    private CoordinateRepository coordinateRepository;

    @Override
    public Coordinate create(Coordinate coordinate) {
        return this.coordinateRepository.save(new CoordinateSchema(
                coordinate.getId(),
                coordinate.getLatitude(),
                coordinate.getAltitude(),
                coordinate.getName())).toCoordinate();
    }

    @Override
    public void delete(Long id) {
        this.coordinateRepository.deleteById(id);
    }

    @Override
    public Optional<Coordinate> findById(Long id) {
        return this.coordinateRepository
                .findById(id)
                .map(CoordinateSchema::toCoordinate);
    }

    @Override
    public List<Coordinate> findAll() {
        return this.coordinateRepository
                .findAll()
                .stream()
                .map(CoordinateSchema::toCoordinate)
                .toList();
    }

}
