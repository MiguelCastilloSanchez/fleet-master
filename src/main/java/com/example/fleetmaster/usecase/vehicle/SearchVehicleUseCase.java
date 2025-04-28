package com.example.fleetmaster.usecase.vehicle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fleetmaster.entity.vehicle.gateway.VehicleGateway;
import com.example.fleetmaster.entity.vehicle.model.Vehicle;

@Service
public class SearchVehicleUseCase {
    
    @Autowired
    private VehicleGateway vehicleGateway;

    public List<Vehicle> execute(){
        return this.vehicleGateway.findAll();
    }
}
