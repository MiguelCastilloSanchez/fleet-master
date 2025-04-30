package com.example.fleetmaster.infrastructure.assignment.dto;

import java.time.LocalDate;


import com.example.fleetmaster.infrastructure.assignment.validation.Update.DriverNotAssignedForUpdate;
import com.example.fleetmaster.infrastructure.assignment.validation.Update.VehicleNotAssignedForUpdate;
import com.example.fleetmaster.usecase.assignment.dto.IAssignmentUpdateData;

import jakarta.validation.constraints.NotNull;

@DriverNotAssignedForUpdate
@VehicleNotAssignedForUpdate
public record AssignmentUpdateData(
    
    @NotNull
    Long assignmentId,

    @NotNull
    Long driverId,

    @NotNull
    Long vehicleId,

    LocalDate startDate
    
) implements IAssignmentUpdateData{

}


