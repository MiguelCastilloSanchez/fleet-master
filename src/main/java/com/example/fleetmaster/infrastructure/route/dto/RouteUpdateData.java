package com.example.fleetmaster.infrastructure.route.dto;

import java.time.LocalDate;

import com.example.fleetmaster.infrastructure.route.validation.Update.AssignmentNotInUseForUpdate;
import com.example.fleetmaster.usecase.route.dto.IRouteUpdateData;

import jakarta.validation.constraints.FutureOrPresent;

@AssignmentNotInUseForUpdate
public record RouteUpdateData(
    String name,

    LocalDate createdDate,
    
    @FutureOrPresent (message = "Travel date must be in the future")
    LocalDate travelDate,
    
    Long endLocationId,
    
    Long assignmentId,
    
    String isSuccessfulRoute,
    
    String problemdescription,
    
    String commentaries
) implements IRouteUpdateData {} 
