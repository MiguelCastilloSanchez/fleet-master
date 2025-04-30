package com.example.fleetmaster.usecase.route.dto;

import java.time.LocalDate;
import java.util.ArrayList;

import com.example.fleetmaster.entity.coordinates.model.Coordinate;

// DTO (Data Transfer Object) interface to invert spring boot lib dependencies,
// respecting the decoupling of the use cases layer.
public interface IRouteUpdateData {

    String name();

    LocalDate createdDate();

    LocalDate travelDate();

    Coordinate endLocation();

    Long assignmentId();

    boolean isSuccessfulRoute();

    String problemdescription();

    ArrayList<String> commentaries();
}
