package com.example.fleetmaster.infrastructure.route.dto;

import java.time.LocalDate;

import com.example.fleetmaster.usecase.route.dto.IRouteUpdateData;

public record RouteUpdateData(
    String name,

    LocalDate createdDate,
    
    LocalDate travelDate,
    
    Long endLocationId,
    
    Long assignmentId,
    
    int isSuccessfulRoute,
    
    String problemdescription,
    
    String commentaries
) implements IRouteUpdateData {} 
