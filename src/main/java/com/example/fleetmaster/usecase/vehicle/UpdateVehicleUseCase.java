package com.example.fleetmaster.usecase.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fleetmaster.entity.vehicle.exception.VehicleNotFoundException;
import com.example.fleetmaster.entity.vehicle.gateway.VehicleGateway;
import com.example.fleetmaster.entity.vehicle.model.Vehicle;
import com.example.fleetmaster.usecase.vehicle.dto.IVehicleUpdateData;

@Service
public class UpdateVehicleUseCase {
    @Autowired
    private VehicleGateway vehicleGateway;

    public Vehicle execute(Long id, IVehicleUpdateData data) throws VehicleNotFoundException{
        Vehicle vehicle = this.vehicleGateway.findById(id).orElseThrow(VehicleNotFoundException::new);

        if(data.plate() != null && !data.plate().isBlank()){
            vehicle.setPlate(data.plate());
        }


        if(data.cost() > 0){
            vehicle.setCost(data.cost());
        }

        if(data.photoUrl() != null && !data.photoUrl().isBlank()){
            vehicle.setPhotoUrl(data.photoUrl());
        }

        

        return this.vehicleGateway.update(vehicle);
    }
}
