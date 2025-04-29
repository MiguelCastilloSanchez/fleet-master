package com.example.fleetmaster.usecase.assignment.dto;

import java.time.LocalDate;

public interface IAssignmentPublicData {

    String id();

    Long driverId();

    Long vehicleId();

    LocalDate startDate();

    LocalDate endDate();

    boolean active();
    
}
