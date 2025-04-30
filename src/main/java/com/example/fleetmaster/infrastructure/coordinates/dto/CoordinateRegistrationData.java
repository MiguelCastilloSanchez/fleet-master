package com.example.fleetmaster.infrastructure.coordinates.dto;

import com.example.fleetmaster.usecase.coordinates.dto.ICoordinateRegistrationData;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CoordinateRegistrationData(
        double latitude,
        double altitude,

        @NotBlank @Size(min = 25, max = 50) String name) implements ICoordinateRegistrationData {
}
