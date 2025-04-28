package com.example.fleetmaster.usecase.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fleetmaster.entity.vehicle.exception.VehicleNotFoundException;
import com.example.fleetmaster.entity.vehicle.gateway.VehicleGateway;
import com.example.fleetmaster.entity.vehicle.model.Vehicle;

@Service
public class GetVehicleUseCase {
    
    @Autowired
    private VehicleGateway vehicleGateway;

    public Vehicle execute(Long id) throws VehicleNotFoundException{
        return this.vehicleGateway.findById(id).orElseThrow(VehicleNotFoundException::new);
    }
}
