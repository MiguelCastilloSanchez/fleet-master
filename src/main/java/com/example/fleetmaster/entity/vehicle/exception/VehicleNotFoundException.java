package com.example.fleetmaster.entity.vehicle.exception;

public class VehicleNotFoundException extends Exception{
    
    public VehicleNotFoundException(){
        super ("Couldn't find the vehicle!");
    }
}
