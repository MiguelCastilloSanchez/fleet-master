package com.example.fleetmaster.infrastructure.route.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.fleetmaster.usecase.route.dto.IRouteRegistrationData;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RouteRegistrationData (
    
    @NotBlank
    @Size(min = 3, max = 50, message="Route Name cannot exceed 15 characters")
    String name,

    @NotNull
    @FutureOrPresent (message = "Travel date must be in the future")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate travelDate,

    @NotNull
    Long endLocationId,
    
    @NotNull
    Long assignmentId
) implements IRouteRegistrationData {}
