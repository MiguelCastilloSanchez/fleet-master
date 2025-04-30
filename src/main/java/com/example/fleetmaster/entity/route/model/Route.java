package com.example.fleetmaster.entity.route.model;
import java.time.LocalDate;
import java.util.ArrayList;


import com.example.fleetmaster.entity.AbstractEntity;
import com.example.fleetmaster.infrastructure.config.db.schema.AssignmentSchema;

public class Route  extends AbstractEntity<Long>{

    private String name;
    private LocalDate createdDate;
    private LocalDate travelDate; 

    private Long startLocationId; 
    private Long endLocationId; 

    private Long assignmentId;
    private Long vehicleId;
    private Long driverId;

    private Boolean successfulRoute;
    private String problemdescription;
    private ArrayList<String> commentaries;

    public Route(String name, LocalDate travelDate, Long endLocationId, AssignmentSchema assignmentsSchema) {
        this.name = name;
        this.createdDate = LocalDate.now();
        this.travelDate = travelDate;
        this.startLocationId = (long) 1;
        this.endLocationId = endLocationId;
        setAssignment(assignmentsSchema);
        this.successfulRoute = false;
        this.problemdescription = "";
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

    public void setCreatedDateetStartLocationId (Long startLocationId) {
        this.startLocationId = startLocationId;
    }

    public Long getStartLocationId() {
        return this.startLocationId;
    }

    public Long getEndLocationId() {
        return endLocationId;
    }

    public void setEndLocationId(Long endLocationId) {
        this.endLocationId = endLocationId;
    }

    public Long getAssignmentId() {
        return assignmentId;
    }

    public void setAssignment(AssignmentSchema assignmentsSchema) {
        this.assignmentId = assignmentsSchema.getId();
        this.vehicleId = assignmentsSchema.toAssignment().getVehicleId();
        this.driverId = assignmentsSchema.toAssignment().getDriverId();
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
}
