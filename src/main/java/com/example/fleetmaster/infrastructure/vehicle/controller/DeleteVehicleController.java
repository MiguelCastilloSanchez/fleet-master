package com.example.fleetmaster.infrastructure.vehicle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.fleetmaster.entity.vehicle.exception.VehicleNotFoundException;
import com.example.fleetmaster.infrastructure.vehicle.dto.VehiclePublicData;
import com.example.fleetmaster.usecase.vehicle.DeleteVehicleUseCase;


@RestController
public class DeleteVehicleController {
    
        @Autowired
    private DeleteVehicleUseCase deleteVehicleUseCase;

    @PutMapping("/vehicle/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VehiclePublicData deleteVehicle(@PathVariable Long id) throws VehicleNotFoundException{
        return new VehiclePublicData(deleteVehicleUseCase.execute(id));
    }
}
