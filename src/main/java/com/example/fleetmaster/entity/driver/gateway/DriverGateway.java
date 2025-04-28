package com.example.fleetmaster.entity.driver.gateway;

import com.example.fleetmaster.entity.driver.model.Driver;

import java.util.List;
import java.util.Optional;

public interface DriverGateway {
    Driver create(Driver driver);
    Driver update(Driver driver);
    void delete(Long id);

    Optional<Driver> findById(Long id);

    List<Driver> findAll();
}
