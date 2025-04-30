package com.example.fleetmaster.infrastructure.config.db.schema;

import jakarta.validation.constraints.NotBlank;

import com.example.fleetmaster.entity.coordinates.model.Coordinate;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Coordinates")
public class CoordinateSchema {
    
    @NotBlank
    @Column(nullable = false)
    private Long latitude;

    @NotBlank
    @Column(nullable = false)
    private Long altitude;

    @NotBlank
    @Column(length = 50, nullable = false)
    private String name;

    public CoordinateSchema(Long latitude, Long altitude, String name) {
        this.latitude = latitude;
        this.altitude = altitude;
        this.name = name;
    }

    public CoordinateSchema() {
    }

    public CoordinateSchema(Coordinate coordinate) {
        this.latitude = coordinate.getLatitude();
        this.altitude = coordinate.getAltitude();
        this.name = coordinate.getName();
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

    public Coordinate toCoordinate() {
        Coordinate coordinate = new Coordinate(
            this.latitude, 
            this.altitude, 
            this.name
        );

        return coordinate;
    }
}
