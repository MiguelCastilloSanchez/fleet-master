package com.example.fleetmaster.infrastructure.config.db.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fleetmaster.infrastructure.config.db.schema.AssignmentSchema;
import com.example.fleetmaster.infrastructure.config.db.schema.DriverSchema;
import com.example.fleetmaster.infrastructure.config.db.schema.VehicleSchema;

@Repository
public interface AssignmentRepository extends JpaRepository<AssignmentSchema, Long> {
    
    List<AssignmentSchema> findAllByActive(boolean active);

    Optional<AssignmentSchema> findByDriverAndActiveTrue(DriverSchema driver);
    Optional<AssignmentSchema> findByVehicleAndActiveTrue(VehicleSchema vehicle);

    List<AssignmentSchema> findAllByDriverOrderByStartDateDesc(DriverSchema driver);
    List<AssignmentSchema> findAllByVehicleOrderByStartDateDesc(VehicleSchema vehicle);

}
