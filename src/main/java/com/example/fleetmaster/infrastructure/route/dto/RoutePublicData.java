package com.example.fleetmaster.infrastructure.route.dto;

import java.time.LocalDate;
import java.util.ArrayList;

import com.example.fleetmaster.entity.route.model.Route;
import com.example.fleetmaster.usecase.route.dto.IRoutePublicData;

public record RoutePublicData (
    String id,
    String name,
    LocalDate createdDate,
    LocalDate travelDate,
    Long startLocationId,
    Long endLocationId,
    Long assignmentId,
    Long vehicleId,
    Long driverId,
    boolean successfulRoute,
    String problemdescription,
    ArrayList<String> commentaries
) implements IRoutePublicData {
    public RoutePublicData(Route route) {
        this(
            route.getId().toString(),
            route.getName(),
            route.getCreatedDate(),
            route.getTravelDate(),
            route.getStartLocationId(),
            route.getEndLocationId(),
            route.getAssignmentId(),
            route.getVehicleID(),
            route.getDriverId(),
            route.isSuccessfulRoute(),
            route.getProblemdescription(),
            route.getCommentaries()
        );
    }

}
