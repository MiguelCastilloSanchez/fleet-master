package com.example.fleetmaster.usecase.vehicle.dto;

// DTO (Data Transfer Object) interface to invert spring boot lib dependencies,
// respecting the decoupling of the use cases layer.
public interface IVehiclePublicData {

    String id();
    
    String brand();

    String vin();

    String plate();

    String purchaseDate();

    double cost();

    String photoUrl();

    String registrationDate();

}
