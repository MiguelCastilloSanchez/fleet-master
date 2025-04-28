package com.example.fleetmaster.usecase.vehicle;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.fleetmaster.entity.vehicle.exception.VehicleNotFoundException;
import com.example.fleetmaster.entity.vehicle.gateway.VehicleGateway;
import com.example.fleetmaster.entity.vehicle.model.Vehicle;


@Service
public class DeleteVehicleUseCase{

    @Autowired
    private VehicleGateway vehicleGateway;

    public Vehicle execute(Long id) throws VehicleNotFoundException{
        Vehicle vehicle = vehicleGateway.findById(id).orElseThrow(VehicleNotFoundException::new);

        vehicleGateway.delete(id);

        return vehicle;
        }
}

