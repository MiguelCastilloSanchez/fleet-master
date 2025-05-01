package com.example.fleetmaster.usecase.coordinates.dto;

// DTO (Data Transfer Object) interface to invert spring boot lib dependencies,
// respecting the decoupling of the use cases layer.
public interface ICoordinateRegistrationData {

    double latitude();

    double altitude();

    String name();
}