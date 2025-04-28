package com.example.fleetmaster.infrastructure.vehicle.dto;

import java.time.LocalDate;

import com.example.fleetmaster.usecase.vehicle.dto.IVehicleRegistrationData;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record VehicleRegistrationData(
        
    @NotBlank
    String brand,

    @NotBlank
    @Size (min = 17, max = 17)
    String vin,

    @NotBlank
    String plate,

    @NotBlank
    LocalDate purchaseDate,

    @NotBlank
    String photoUrl,

    @NotBlank
    LocalDate registrationDate
) implements IVehicleRegistrationData{}
