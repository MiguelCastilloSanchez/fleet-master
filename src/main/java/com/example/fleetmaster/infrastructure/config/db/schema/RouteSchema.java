package com.example.fleetmaster.infrastructure.config.db.schema;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.fleetmaster.entity.coordinates.exception.CoordinateNotFoundException;
import com.example.fleetmaster.entity.route.exception.RouteNotFoundException;
import com.example.fleetmaster.entity.route.model.Route;
import com.example.fleetmaster.infrastructure.config.db.repository.AssignmentRepository;
import com.example.fleetmaster.infrastructure.config.db.repository.CoordinateRepository;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Routes")
public class RouteSchema extends AbstractEntitySchema<Long> {

    @NotBlank
    @Column(length = 15, nullable = false)
    private String name;

    @NotBlank
    @Column(nullable = false)
    private LocalDate createdDate;

    @NotBlank
    @Column(nullable = false)
    private LocalDate travelDate;

    @NotBlank
    @Column(nullable = false)
    private CoordinateSchema startLocation; // its a constant

    @NotBlank
    @Column(nullable = false)
    private CoordinateSchema endLocation;

    @NotNull
    @NotBlank
    @Column(nullable = false)
    private AssignmentSchema assignment;

    @NotBlank
    @Column(nullable = false)
    private Long vehicleId;

    @NotBlank
    @Column(nullable = false)
    private Long driverId;

    @NotBlank
    @Column()
    private Boolean successfulRoute;

    @NotBlank
    @Column(length = 250)
    private String problemdescription;

    @NotBlank
    @Column()
    private ArrayList<String> commentaries; // this could be a list of objects with a description, date, and user.

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private CoordinateRepository coordinateRepository;

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

    public RouteSchema(Route route) {
        this.name = route.getName();
        this.createdDate = route.getCreatedDate();
        this.travelDate = route.getTravelDate();
        this.setStartLocation(route.getStartLocation().getId());
        this.setEndLocation(route.getEndLocation().getId());
        this.setAssignment(route.getAssignmentId());
        this.successfulRoute = route.isSuccessfulRoute();
        this.problemdescription = route.getProblemdescription();
        this.commentaries = route.getCommentaries();
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

    public void setStartLocation(Long startLocationId) {
        CoordinateSchema coordinateSchema = coordinateRepository.findById(startLocationId)
                .orElseThrow(CoordinateNotFoundException::new);
        this.startLocation = coordinateSchema;
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

    public void setEndLocation(Long endLocationId) {
        CoordinateSchema coordinateSchema = coordinateRepository.findById(endLocationId)
                .orElseThrow(CoordinateNotFoundException::new);
        this.endLocation = coordinateSchema;
    }

    public AssignmentSchema getAssignment() {
        return assignment;
    }

    public void setAssignment(AssignmentSchema assignment) {
        this.assignment = assignment;
        this.vehicleId = this.assignment.toAssignment().getVehicleId();
        this.driverId = this.assignment.toAssignment().getDriverId();
    }

    public void setAssignment(Long assignmentId) {
        AssignmentSchema assignmentSchema = assignmentRepository.findById(assignmentId)
                .orElseThrow(RouteNotFoundException::new);
        setAssignment(assignmentSchema);
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
                this.getEndLocation().toCoordinate(),
                this.getAssignment().getId());
        route.setId(this.getId());

        return route;
    }

    public void updateRoute(Route route) {
        this.setName(route.getName());
        this.setCreatedDate(route.getCreatedDate());
        this.setTravelDate(route.getTravelDate());
        this.setEndLocation(route.getEndLocation().getId());
        this.setAssignment(route.getAssignmentId());
        this.setSuccessfulRoute(route.isSuccessfulRoute());
        this.setProblemdescription(route.getProblemdescription());
        this.setCommentaries(route.getCommentaries());
    }

}
