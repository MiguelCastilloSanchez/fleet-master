package com.example.fleetmaster.infrastructure.route.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.fleetmaster.entity.coordinates.model.Coordinate;
import com.example.fleetmaster.usecase.route.dto.IRouteRegistrationData;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RouteRegistrationData (
    
    @NotBlank
    @Size(min = 3, max = 50)
    String name,

    @NotBlank
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate travelDate,

    @NotBlank
    Coordinate endLocation, // this most be changed to a location object

    @NotBlank
    Long assignmentId
) implements IRouteRegistrationData {}
