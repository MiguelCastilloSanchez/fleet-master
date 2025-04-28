package com.example.fleetmaster.entity.vehicle.exception;

public class VehicleNotFoundException extends  RuntimeException{
    
    public VehicleNotFoundException(){
        super ("Couldn't find the vehicle!");
    }
}
