package com.example.fleetmaster.infrastructure.driver.dto;

import com.example.fleetmaster.usecase.driver.dto.IDriverUpdateData;

public record DriverUpdateData(
    String address,

    double salary
) implements IDriverUpdateData{
    
}
