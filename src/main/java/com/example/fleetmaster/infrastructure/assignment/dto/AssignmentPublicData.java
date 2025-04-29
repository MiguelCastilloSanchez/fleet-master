package com.example.fleetmaster.infrastructure.assignment.dto;

import java.time.LocalDate;

import com.example.fleetmaster.entity.assigment.model.Assignment;
import com.example.fleetmaster.usecase.assignment.dto.IAssignmentPublicData;

public record AssignmentPublicData(
    
    String id,

    Long driverId,

    Long vehicleId,

    LocalDate startDate,

    LocalDate endDate,

    boolean active ) implements IAssignmentPublicData{

        public AssignmentPublicData(Assignment assignment){
            this(
                assignment.getId().toString(),
                assignment.getDriverId(),
                assignment.getVehicleId(),
                assignment.getStartDate(),
                assignment.getEndDate(),
                assignment.isActive() 
            );
        }
    }
    
