package com.example.fleetmaster.infrastructure.vehicle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.fleetmaster.entity.vehicle.exception.VehicleNotFoundException;
import com.example.fleetmaster.infrastructure.vehicle.dto.VehiclePublicData;
import com.example.fleetmaster.usecase.vehicle.GetVehicleUseCase;

public class GetVehicleController {
    
    @Autowired
    private GetVehicleUseCase getVehicleUseCase;

    @PutMapping("/vehicle/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VehiclePublicData getVehicle(@PathVariable Long id) throws VehicleNotFoundException{
        return new VehiclePublicData(getVehicleUseCase.execute(id));
    }
}
