package com.example.fleetmaster.infrastructure.config.db.schema;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;

import com.example.fleetmaster.entity.route.model.Route;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Routes")
public class RouteSchema extends AbstractEntitySchema<Long> {

    @NotBlank
    @Column(length = 15, nullable = false)
    private String name;

    @Column()
    private LocalDate createdDate = LocalDate.now();

    @NotNull
    @Column(nullable = false)
    private LocalDate travelDate;

    @Column()
    private CoordinateSchema startLocation = new CoordinateSchema(20.0, 20.0, "Company location"); // its a constant

    @NotNull
    @Column(nullable = false)
    private CoordinateSchema endLocation;

    @NotNull
    @Column(nullable = false)
    private AssignmentSchema assignment;

    @NotNull
    @Column(nullable = false)
    private Long vehicleId;

    @NotNull
    @Column(nullable = false)
    private Long driverId;

    @Column()
    private Boolean successfulRoute = false;

    @Column(length = 250, nullable = true)
    private String problemdescription = "";

    @Column()
    private ArrayList<String> commentaries; // this could be a list of objects with a description, date, and user.

    public RouteSchema(String name, LocalDate travelDate, CoordinateSchema endLocation, AssignmentSchema assignment) {
        this.name = name;
        this.createdDate = LocalDate.now();
        this.travelDate = travelDate;
        // this.startLocation = CONSTANTS.START_LOCATION;
        this.endLocation = endLocation;
        setAssignment(assignment);
        this.commentaries = new ArrayList<>();
    }

    public RouteSchema() {

    }

    public RouteSchema(Long id, String name, LocalDate travelDate, CoordinateSchema endLocation,
            AssignmentSchema assignment) {
        this.setId(id);
        this.name = name;
        this.createdDate = LocalDate.now();
        this.travelDate = travelDate;
        // this.startLocation = CONSTANTS.START_LOCATION;
        this.endLocation = endLocation;
        setAssignment(assignment);
        this.commentaries = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(LocalDate travelDate) {
        this.travelDate = travelDate;
    }

    public void setStartLocation(CoordinateSchema startLocation) {
        this.startLocation = startLocation;
    }

    public CoordinateSchema getStartLocation() {
        return startLocation;
    }

    public CoordinateSchema getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(CoordinateSchema endLocation) {
        this.endLocation = endLocation;
    }

    public AssignmentSchema getAssignment() {
        return assignment;
    }

    public void setAssignment(AssignmentSchema assignment) {
        this.assignment = assignment;
        this.vehicleId = this.assignment.toAssignment().getVehicleId();
        this.driverId = this.assignment.toAssignment().getDriverId();
    }

    public Long getVehicleID() {
        return this.vehicleId;
    }

    public Long getDriverId() {
        return this.driverId;
    }

    public Boolean isSuccessfulRoute() {
        return successfulRoute;
    }

    public void setSuccessfulRoute(Boolean successfulRoute) {
        this.successfulRoute = successfulRoute;
    }

    public String getProblemdescription() {
        return problemdescription;
    }

    public void setProblemdescription(String problemdescription) {
        this.problemdescription = problemdescription;
    }

    public ArrayList<String> getCommentaries() {
        return commentaries;
    }

    public void addCommentary(String commentary) {
        this.commentaries.add(commentary);

    }

    public void removeCommentary(String commentary) {
        this.commentaries.remove(commentary);
    }

    public void clearCommentaries() {
        this.commentaries.clear();
    }

    public void setCommentaries(ArrayList<String> commentaries) {
        this.commentaries = commentaries;
    }

    public Route toRoute() {
        Route route = new Route(
                this.getName(),
                this.getTravelDate(),
                this.getEndLocation().toCoordinate().getId(),
                this.getAssignment());
        route.setId(this.getId());

        return route;
    }

    public Route toUpdateRoute() {
        Route route = new Route(
                this.getName(),
                this.getTravelDate(),
                this.getEndLocation().toCoordinate().getId(),
                this.getAssignment(),
                this.getProblemdescription(),
                this.isSuccessfulRoute(),
                this.getCommentaries());
        route.setId(this.getId());

        return route;
    }

    public void updateRoute(Route route) {
        this.setName(route.getName());
        this.setCreatedDate(route.getCreatedDate());
        this.setTravelDate(route.getTravelDate());
        this.setSuccessfulRoute(route.isSuccessfulRoute());
        this.setProblemdescription(route.getProblemdescription());
        this.setCommentaries(route.getCommentaries());
    }

}
