package com.example.fleetmaster.entity.assigment.model;

import java.time.LocalDate;

import com.example.fleetmaster.entity.AbstractEntity;

public class Assignment extends AbstractEntity<Long> {

    private long driverId;
    private long vehicleId;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean active;

    public Assignment(long driverId, long vehicleId, LocalDate startDate) {
        this.driverId = driverId;
        this.vehicleId = vehicleId;
        this.startDate = startDate;
        this.active = true;
    }

    public long getDriverId() {
        return driverId;
    }
    public void setDriverId(long driverId) {
        this.driverId = driverId;
    }
    public long getVehicleId() {
        return vehicleId;
    }
    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

}
