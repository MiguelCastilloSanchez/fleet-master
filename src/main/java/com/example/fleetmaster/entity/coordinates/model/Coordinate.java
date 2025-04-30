package com.example.fleetmaster.entity.coordinates.model;

import com.example.fleetmaster.entity.AbstractEntity;

public class Coordinate extends AbstractEntity<Long> {

    private long latitude;
    private long altitude;
    private String name;

    public Coordinate(long latitude, long altitude, String name) {
        this.latitude = latitude;
        this.altitude = altitude;
        this.name = name;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public long getAltitude() {
        return altitude;
    }

    public void setAltitude(long altitude) {
        this.altitude = altitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
