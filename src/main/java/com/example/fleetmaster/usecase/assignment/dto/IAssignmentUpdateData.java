package com.example.fleetmaster.usecase.assignment.dto;

import java.time.LocalDate;

public interface IAssignmentUpdateData {
    

    Long assignmentId();

    Long driverId();

    Long vehicleId();

    LocalDate startDate();

   
    
}


