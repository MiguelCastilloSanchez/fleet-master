package com.example.fleetmaster.infrastructure.route.dto;

import java.time.LocalDate;
import java.util.ArrayList;

import com.example.fleetmaster.usecase.route.dto.IRouteUpdateData;

public record RouteUpdateData(
    String name,

    LocalDate createdDate,
    
    LocalDate travelDate,
    
    Long endLocationId,
    
    Long assignmentId,
    
    boolean isSuccessfulRoute,
    
    String problemdescription,
    
    ArrayList<String> commentaries
) implements IRouteUpdateData {} 
