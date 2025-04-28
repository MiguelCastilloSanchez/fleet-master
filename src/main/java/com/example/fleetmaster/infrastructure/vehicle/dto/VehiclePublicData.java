package com.example.fleetmaster.infrastructure.vehicle.dto;

import java.time.LocalDate;

import com.example.fleetmaster.entity.vehicle.model.Vehicle;
import com.example.fleetmaster.usecase.vehicle.dto.IVehiclePublicData;

public record VehiclePublicData (
    String id,
    
    String brand,

    String vin,

    String plate,

    LocalDate purchaseDate,

    String photoUrl,

    LocalDate registrationDate
)implements IVehiclePublicData{
    public VehiclePublicData(Vehicle vehicle){
        this(
            vehicle.getId().
            toString(),
            vehicle.getBrand(),
            vehicle.getVin(),
            vehicle.getPlate(),
            vehicle.getPurchaseDate(),
            vehicle.getPhotoUrl(),
            vehicle.getRegistrationDate()
            );
    }
}
