package com.example.fleetmaster.entity.vehicle.gateway;

import com.example.fleetmaster.entity.vehicle.model.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleGateway {
    Vehicle create(Vehicle vehicle);
    Vehicle update(Vehicle vehicle);
    void delete(Long id);

    Optional<Vehicle> findById(Long id);

    List<Vehicle> findAll();
}
