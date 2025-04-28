package com.example.fleetmaster.usecase.vehicle.dto;


// DTO (Data Transfer Object) interface to invert spring boot lib dependencies,
// respecting the decoupling of the use cases layer.
public interface IVehicleUpdateData {
    
    String plate();

    String photoUrl();
}
