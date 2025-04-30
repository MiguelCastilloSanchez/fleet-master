package com.example.fleetmaster.infrastructure.route.dto;

import java.time.LocalDate;
import java.util.ArrayList;

import com.example.fleetmaster.entity.coordinates.model.Coordinate;
import com.example.fleetmaster.usecase.route.dto.IRouteUpdateData;

public record RouteUpdateData(
    String name,

    LocalDate createdDate,
    
    LocalDate travelDate,
    
    Coordinate endLocation, // this most be changed to a location object
    
    Long assignmentId,
    
    boolean isSuccessfulRoute,
    
    String problemdescription,
    
    ArrayList<String> commentaries
) implements IRouteUpdateData {} 
