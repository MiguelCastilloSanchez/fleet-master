package com.example.fleetmaster.infrastructure.vehicle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.example.fleetmaster.infrastructure.vehicle.dto.VehiclePublicData;
import com.example.fleetmaster.usecase.vehicle.SearchVehicleUseCase;
import com.example.fleetmaster.entity.vehicle.model.Vehicle;

import java.util.List;

@RestController
public class SearchVehicleController {
    
    @Autowired
    private SearchVehicleUseCase searchVehicleUseCase;

    @GetMapping("/vehicle")
    @ResponseStatus(HttpStatus.OK)
    public List<VehiclePublicData> searchVehicle(){
        List<Vehicle> vehicles = this.searchVehicleUseCase.execute();

        return vehicles.stream().map(VehiclePublicData::new).toList();
    }
}
