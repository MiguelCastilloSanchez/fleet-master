package com.example.fleetmaster.infrastructure.config.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fleetmaster.entity.coordinates.model.Coordinate;
import com.example.fleetmaster.infrastructure.config.db.schema.RouteSchema;
import java.util.Optional;
import java.time.LocalDate;
import java.util.Collection;

@Repository
public interface RouteRepository extends JpaRepository<RouteSchema, Long> {
    Optional<RouteSchema> findByCreatedDate(LocalDate createdDate);

    Optional<RouteSchema> findByTravelDate(LocalDate travelDate);

    Optional<RouteSchema> findByEndLocation(Coordinate endLocation);

    Optional<RouteSchema> findByVehicleId(Long vehicleId);

    Optional<RouteSchema> findByDriverId(Long driverId);

    Optional<RouteSchema> findBySuccessfulRoute(Boolean successfulRoute);

    
    Collection<RouteSchema> findAllByCreatedDate(LocalDate createdDate);

    Collection<RouteSchema> findAllByTravelDate(LocalDate travelDate);

    Collection<RouteSchema> findAllByEndLocation(Coordinate endLocation);

    Collection<RouteSchema> findAllByVehicleId(Long vehicleId);

    Collection<RouteSchema> findAllByDriverId(Long driverId);

    Collection<RouteSchema> findAllBySuccessfulRoute(Boolean successfulRoute);
}

