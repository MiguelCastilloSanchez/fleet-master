package com.example.fleetmaster.infrastructure.vehicle.dto;

import com.example.fleetmaster.usecase.vehicle.dto.IVehicleUpdateData;

public record VehicleUpdateData(
    String plate,
    
    String photoUrl
) implements IVehicleUpdateData{}
