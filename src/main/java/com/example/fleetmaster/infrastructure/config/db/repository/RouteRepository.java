package com.example.fleetmaster.infrastructure.config.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.fleetmaster.infrastructure.config.db.schema.RouteSchema;
import java.util.Optional;
import java.time.LocalDate;
import java.util.Collection;

@Repository
public interface RouteRepository extends JpaRepository<RouteSchema, Long> {
    Optional<RouteSchema> findByCreatedDate(LocalDate createdDate);

    Optional<RouteSchema> findByTravelDate(LocalDate travelDate);

    Optional<RouteSchema> findByEndLocation(String endLocation);

    Optional<RouteSchema> findByVehicle(String vehicle);

    Optional<RouteSchema> findByResponsibleUser(String responsibleUser);

    Optional<RouteSchema> findBySuccessfulRoute(Boolean successfulRoute);

    
    Collection<RouteSchema> findAllByCreatedDate(LocalDate createdDate);

    Collection<RouteSchema> findAllByTravelDate(LocalDate travelDate);

    Collection<RouteSchema> findAllByEndLocation(String endLocation);

    Collection<RouteSchema> findAllByVehicle(String vehicle);

    Collection<RouteSchema> findAllByResponsibleUser(String responsibleUser);

    Collection<RouteSchema> findAllBySuccessfulRoute(Boolean successfulRoute);
}

