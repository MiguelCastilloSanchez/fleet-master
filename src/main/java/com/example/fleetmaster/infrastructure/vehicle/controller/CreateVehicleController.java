package com.example.fleetmaster.infrastructure.vehicle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.fleetmaster.infrastructure.vehicle.dto.VehiclePublicData;
import com.example.fleetmaster.infrastructure.vehicle.dto.VehicleRegistrationData;
import com.example.fleetmaster.usecase.vehicle.CreateVehicleUseCase;

import jakarta.validation.Valid;

@RestController
public class CreateVehicleController {
    
    @Autowired
    private CreateVehicleUseCase createVehicleUseCase;

    @PostMapping("/vehicle")
    @ResponseStatus(HttpStatus.CREATED)
    public VehiclePublicData createVehicle(@Valid @RequestBody VehicleRegistrationData data){
        return new VehiclePublicData(createVehicleUseCase.execute(data));
    }
}
