package com.example.fleetmaster.infrastructure.vehicle.gateway;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.fleetmaster.entity.vehicle.gateway.VehicleGateway;
import com.example.fleetmaster.infrastructure.config.db.repository.VehicleRepository;
import com.example.fleetmaster.infrastructure.config.db.schema.VehicleSchema;
import com.example.fleetmaster.entity.vehicle.model.Vehicle;

@Component
public class VehicleDatabaseGateway implements VehicleGateway{
    
    @Autowired
    private VehicleRepository vechicleRepository;

    @Override
    public Vehicle create(Vehicle vehicle){
        return this.vechicleRepository.save(new VehicleSchema(vehicle)).toVehicle();

    }

    @Override
    public Vehicle update(Vehicle vehicle){
        return this.vechicleRepository.save(new VehicleSchema(vehicle)).toVehicle();
    }

    @Override
    public void delete(Long id) {
        this.vechicleRepository.deleteById(id);
    }

    @Override
    public Optional<Vehicle> findById(Long id) {
        return vechicleRepository
                .findById(id)
                .map(VehicleSchema::toVehicle);
    }

    @Override
    public List<Vehicle> findAll() {
        return vechicleRepository
                .findAll()
                .stream()
                .map(VehicleSchema::toVehicle)
                .toList();
    }
}