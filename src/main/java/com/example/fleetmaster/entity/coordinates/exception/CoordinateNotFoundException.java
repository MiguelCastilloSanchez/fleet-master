package com.example.fleetmaster.entity.coordinates.exception;

public class CoordinateNotFoundException extends RuntimeException{
    
    public CoordinateNotFoundException() {
        super("Couldn't find the coordinate!!!");
    }
}
