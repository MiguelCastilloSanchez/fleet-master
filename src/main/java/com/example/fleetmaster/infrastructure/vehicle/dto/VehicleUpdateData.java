package com.example.fleetmaster.infrastructure.vehicle.dto;

import com.example.fleetmaster.usecase.vehicle.dto.IVehicleUpdateData;

public record VehicleUpdateData(

    String brand,

    String vin,

    String plate,

    String purchaseDate,

    double cost,
    
    String photoUrl,

    String registrationDate
) implements IVehicleUpdateData{}
