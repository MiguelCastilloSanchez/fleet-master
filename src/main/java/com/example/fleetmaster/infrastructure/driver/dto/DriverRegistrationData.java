package com.example.fleetmaster.infrastructure.driver.dto;

import java.time.LocalDate;

import com.example.fleetmaster.usecase.driver.dto.IDriverRegistrationData;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DriverRegistrationData(
    @NotBlank
    String name,

    @NotBlank
    @Size(min = 18, max = 18)
    String curp,

    @NotBlank
    LocalDate birthDate,

    @NotBlank
    String address,

    @NotBlank
    double salary,

    @NotBlank
    long licenseNumber,

    @NotBlank
    LocalDate systemEntryDate
) implements IDriverRegistrationData{

    
}
