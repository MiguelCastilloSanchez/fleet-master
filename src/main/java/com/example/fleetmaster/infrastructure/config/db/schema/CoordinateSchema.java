package com.example.fleetmaster.infrastructure.config.db.schema;

import jakarta.validation.constraints.NotBlank;

import com.example.fleetmaster.entity.coordinates.model.Coordinate;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Coordinates")
public class CoordinateSchema extends AbstractEntitySchema<Long>{
    
    @Column(nullable = false)
    private double latitude;

    @Column(nullable = false)
    private double altitude;

    @NotBlank
    @Column(length = 50, nullable = false)
    private String name;

    public CoordinateSchema(double latitude, double altitude, String name) {
        this.latitude = latitude;
        this.altitude = altitude;
        this.name = name;
    }

    public CoordinateSchema() {
    }

    public CoordinateSchema(Long id, double latitude, double altitude, String name) {
        this.setId(id);
        this.latitude = latitude;
        this.altitude = altitude;
        this.name = name;
    }

    public CoordinateSchema(Coordinate coordinate) {
        this.latitude = coordinate.getLatitude();
        this.altitude = coordinate.getAltitude();
        this.name = coordinate.getName();
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

    public Coordinate toCoordinate() {
        Coordinate coordinate = new Coordinate(
            this.latitude, 
            this.altitude, 
            this.name
        );

        coordinate.setId(this.getId());

        return coordinate;
    }
}
