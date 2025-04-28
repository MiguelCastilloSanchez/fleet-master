package com.example.fleetmaster.usecase.driver.dto;

import java.time.LocalDate;

public interface IDriverPublicData {

    String id();

    String name();

    LocalDate birthDate();

    String curp();

    String address();

    double salary();

    long licenseNumber();

    LocalDate systemEntryDate();
}
