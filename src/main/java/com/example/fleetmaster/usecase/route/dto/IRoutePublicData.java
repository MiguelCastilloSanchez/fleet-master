package com.example.fleetmaster.usecase.route.dto;

import java.time.LocalDate;
import java.util.ArrayList;

import com.example.fleetmaster.entity.coordinates.model.Coordinate;

// DTO (Data Transfer Object) interface to invert spring boot lib dependencies,
// respecting the decoupling of the use cases layer.
public interface IRoutePublicData {

    String id();

    String name();

    LocalDate createdDate();

    LocalDate travelDate();

    Coordinate startLocation(); // its a constant

    Coordinate endLocation();

    Long assignmentId();

    Long vehicleId();

    Long driverId();

    boolean successfulRoute();

    String problemdescription();

    ArrayList<String> commentaries();
}