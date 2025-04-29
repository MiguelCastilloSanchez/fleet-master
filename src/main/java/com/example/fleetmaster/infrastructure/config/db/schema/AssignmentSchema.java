package com.example.fleetmaster.infrastructure.config.db.schema;

import java.time.LocalDate;

import com.example.fleetmaster.entity.assigment.model.Assignment;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Assignments")
public class AssignmentSchema extends AbstractEntitySchema<Long>{

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "driver_id")
    private DriverSchema driver;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "vehicle_id")
    private VehicleSchema vehicle;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = true)
    private LocalDate endDate;

    @Column(nullable = false)
    private boolean active = true;

    public AssignmentSchema( DriverSchema driver, VehicleSchema vehicle, LocalDate startDate) {
        this.driver = driver;
        this.vehicle = vehicle;
        this.startDate = startDate;
    }

    public AssignmentSchema(){

    }

    public AssignmentSchema(Long id, DriverSchema driver, VehicleSchema vehicle, LocalDate startDate, LocalDate endDate, boolean active) {
        this.setId(id);
        this.driver = driver;
        this.vehicle = vehicle;
        this.startDate = startDate;
        this.endDate = endDate;
        this.active = active;
    }

    public AssignmentSchema(Assignment assignment, DriverSchema driver, VehicleSchema vehicle){
        this.driver = driver;
        this.vehicle = vehicle;
        this.startDate = assignment.getStartDate();
        this.endDate = assignment.getEndDate();
        this.active = assignment.isActive();
    }

    public DriverSchema getDriver() {
        return driver;
    }

    public void setDriver(DriverSchema driver) {
        this.driver = driver;
    }

    public VehicleSchema getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleSchema vehicle) {
        this.vehicle = vehicle;
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

    public Assignment toAssignment(){
        Assignment assignment = new Assignment(
            this.getDriver().getId(),
            this.getVehicle().getId(),
            this.getStartDate(),
            this.getEndDate(),
            this.isActive()
        );

        assignment.setId(this.getId());
        return assignment;
    }

    public void updateAssignment(Assignment assignment){
            this.endDate = assignment.getEndDate();
            this.active = assignment.isActive();
    }

    
}
