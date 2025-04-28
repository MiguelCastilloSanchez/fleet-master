package com.example.fleetmaster.infrastructure.driver.dto;

import java.time.LocalDate;

import com.example.fleetmaster.entity.driver.model.Driver;
import com.example.fleetmaster.usecase.driver.dto.IDriverPublicData;

public record DriverPublicData(

    String id,

    String name,

    LocalDate birthDate,

    String curp,

    String address,

    double salary,

    long licenseNumber,

    LocalDate systemEntryDate


) implements IDriverPublicData{

    public DriverPublicData(Driver driver){
        this(
            driver.getId().toString(),
            driver.getName(),
            driver.getBirthDate(),
            driver.getCurp(),
            driver.getAddress(),
            driver.getSalary(),
            driver.getLicenseNumber(),
            driver.getSystemEntryDate()

        );
    }
    
}
