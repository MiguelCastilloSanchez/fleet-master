package com.example.fleetmaster.usecase.vehicle;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fleetmaster.entity.vehicle.gateway.VehicleGateway;
import com.example.fleetmaster.entity.vehicle.model.Vehicle;
import com.example.fleetmaster.usecase.vehicle.dto.IVehicleRegistrationData;

@Service
public class CreateVehicleUseCase {
    
    @Autowired
    private VehicleGateway vehicleGateway;

    public Vehicle execute(IVehicleRegistrationData data){
        Vehicle vehicle = new Vehicle(data.brand(), data.vin(), data.plate(), data.purchaseDate(), data.photoUrl(), LocalDate.now());
        return this.vehicleGateway.create(vehicle);
    }
}
