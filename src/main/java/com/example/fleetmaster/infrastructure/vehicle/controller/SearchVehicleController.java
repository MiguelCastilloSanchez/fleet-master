package com.example.fleetmaster.infrastructure.vehicle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.fleetmaster.entity.vehicle.exception.VehicleNotFoundException;
import com.example.fleetmaster.infrastructure.vehicle.dto.VehiclePublicData;
import com.example.fleetmaster.usecase.vehicle.SearchVehicleUseCase;
import com.example.fleetmaster.entity.vehicle.model.Vehicle;

import java.util.List;

public class SearchVehicleController {
    
    @Autowired
    private SearchVehicleUseCase searchVehicleUseCase;

    @PutMapping("/vehicle")
    @ResponseStatus(HttpStatus.OK)
    public List<VehiclePublicData> searchVehicle(@PathVariable Long id) throws VehicleNotFoundException{
        List<Vehicle> vehicles = this.searchVehicleUseCase.execute();

        return vehicles.stream().map(VehiclePublicData::new).toList();
    }
}
