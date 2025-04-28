package com.example.fleetmaster.infrastructure.driver.gateway;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.fleetmaster.entity.driver.gateway.DriverGateway;
import com.example.fleetmaster.entity.driver.model.Driver;
import com.example.fleetmaster.infrastructure.config.db.repository.DriverRepository;
import com.example.fleetmaster.infrastructure.config.db.schema.DriverSchema;


@Component
public class DriverDatabaseGateway implements DriverGateway{
    
    @Autowired
    private DriverRepository driverRepository;

    @Override
    public Driver create(Driver driver){
        return this.driverRepository.save(new DriverSchema(driver)).toDriver();

    }

    @Override
    public Driver update(Driver driver){
        return this.driverRepository.save(new DriverSchema(driver)).toDriver();
    }

    @Override
    public void delete(Long id) {
        this.driverRepository.deleteById(id);
    }

    @Override
    public Optional<Driver> findById(Long id) {
        return driverRepository
                .findById(id)
                .map(DriverSchema::toDriver);
    }

    @Override
    public List<Driver> findAll() {
        return driverRepository
                .findAll()
                .stream()
                .map(DriverSchema::toDriver)
                .toList();
    }
}
