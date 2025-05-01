package com.example.fleetmaster.usecase.route.dto;

import java.time.LocalDate;
import java.util.ArrayList;

// DTO (Data Transfer Object) interface to invert spring boot lib dependencies,
// respecting the decoupling of the use cases layer.
public interface IRoutePublicData {

    String id();

    String name();

    LocalDate createdDate();

    LocalDate travelDate();

    Long startLocationId();

    Long endLocationId();

    Long assignmentId();

    Long vehicleId();

    Long driverId();

    boolean successfulRoute();

    String problemdescription();

    ArrayList<String> commentaries();
}