package com.example.fleetmaster.entity.route.exception;

public class RouteNotFoundException extends RuntimeException{
    
    public RouteNotFoundException() {
        super("Couldn't find the route!!!");
    }
}
