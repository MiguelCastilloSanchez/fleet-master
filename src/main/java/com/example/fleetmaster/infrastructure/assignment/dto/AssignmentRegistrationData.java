package com.example.fleetmaster.infrastructure.assignment.dto;

import java.time.LocalDate;

import com.example.fleetmaster.infrastructure.assignment.validation.Register.DriverNotAssigned;
import com.example.fleetmaster.infrastructure.assignment.validation.Register.VehicleNotAssigned;
import com.example.fleetmaster.usecase.assignment.dto.IAssignmentRegistrationData;


import jakarta.validation.constraints.NotNull;

public record AssignmentRegistrationData(

    @NotNull
    @DriverNotAssigned
    Long driverId,

    @NotNull
    @VehicleNotAssigned
    Long vehicleId,

    
    LocalDate startDate
    
) implements IAssignmentRegistrationData{

}
