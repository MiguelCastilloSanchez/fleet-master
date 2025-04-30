package com.example.fleetmaster.usecase.route.dto;

import java.time.LocalDate;
import java.util.ArrayList;

// DTO (Data Transfer Object) interface to invert spring boot lib dependencies,
// respecting the decoupling of the use cases layer.
public interface IRouteUpdateData {

    String name();

    LocalDate createdDate();

    LocalDate travelDate();

    Long endLocationId();

    Long assignmentId();

    boolean isSuccessfulRoute();

    String problemdescription();

    ArrayList<String> commentaries();
}
