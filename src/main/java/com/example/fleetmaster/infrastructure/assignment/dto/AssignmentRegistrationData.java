package com.example.fleetmaster.infrastructure.assignment.dto;

import java.time.LocalDate;


import com.example.fleetmaster.usecase.assignment.dto.IAssignmentRegistrationData;


import jakarta.validation.constraints.NotNull;

public record AssignmentRegistrationData(

    @NotNull
    Long driverId,

    @NotNull
    Long vehicleId,

    
    LocalDate startDate
    
) implements IAssignmentRegistrationData{

}
