package com.example.fleetmaster.usecase.vehicle.dto;

import java.time.LocalDate;


// DTO (Data Transfer Object) interface to invert spring boot lib dependencies,
// respecting the decoupling of the use cases layer.
public interface IVehicleRegistrationData {
    
    String brand();

    String vin();

    String plate();
    
    LocalDate purchaseDate();

    String photoUrl();

    LocalDate registrationDate();
}
