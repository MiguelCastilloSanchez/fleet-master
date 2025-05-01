package com.example.fleetmaster.entity.coordinates.model;

import com.example.fleetmaster.entity.AbstractEntity;

public class Coordinate extends AbstractEntity<Long> {

    private double latitude;
    private double altitude;
    private String name;

    public Coordinate(double latitude, double altitude, String name) {
        this.latitude = latitude;
        this.altitude = altitude;
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
