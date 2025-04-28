package com.example.fleetmaster.entity.driver.exception;

public class DriverNotFoundException extends Exception{
    
    public DriverNotFoundException(){
        super ("Couldn't find the driver!");
    }
}
