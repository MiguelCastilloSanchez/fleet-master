package com.example.fleetmaster.infrastructure.vehicle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.fleetmaster.entity.vehicle.exception.VehicleNotFoundException;
import com.example.fleetmaster.infrastructure.vehicle.dto.VehiclePublicData;
import com.example.fleetmaster.infrastructure.vehicle.dto.VehicleUpdateData;
import com.example.fleetmaster.usecase.vehicle.UpdateVehicleUseCase;

import jakarta.validation.Valid;

@RestController
public class UpdateVehicleController {
    
    @Autowired
    private UpdateVehicleUseCase updateVehicleUseCase;

    @PutMapping("/vehicle/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VehiclePublicData updateVehicle(@PathVariable Long id, @Valid @RequestBody VehicleUpdateData data) throws VehicleNotFoundException{
        return new VehiclePublicData(updateVehicleUseCase.execute(id, data));
    }
}