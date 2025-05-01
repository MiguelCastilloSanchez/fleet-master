package com.example.fleetmaster.usecase.route.dto;

import java.time.LocalDate;

// DTO (Data Transfer Object) interface to invert spring boot lib dependencies,
// respecting the decoupling of the use cases layer.
public interface IRouteRegistrationData {

    String name();

    LocalDate travelDate();

    Long endLocationId();

    Long assignmentId();
}