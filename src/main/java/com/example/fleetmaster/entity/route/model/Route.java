package com.example.fleetmaster.entity.route.model;
import java.time.LocalDate;
import java.util.ArrayList;


import com.example.fleetmaster.entity.AbstractEntity;
import com.example.fleetmaster.entity.assigment.model.Assignment;
import com.example.fleetmaster.entity.coordinates.model.Coordinate;
import com.example.fleetmaster.usecase.assignment.GetAssignmentUseCase;

public class Route  extends AbstractEntity<Long>{

    private String name;
    private LocalDate createdDate;
    private LocalDate travelDate; 

    private Coordinate startLocation; 
    private Coordinate endLocation; 

    private Long assignmentId;
    private Long vehicleId;
    private Long driverId;

    private Boolean successfulRoute;
    private String problemdescription;
    private ArrayList<String> commentaries;

    public Route(String name, LocalDate travelDate, Coordinate endLocation, Long assignmentId) {
        this.name = name;
        this.createdDate = LocalDate.now();
        this.travelDate = travelDate;
        // this.startLocation = CONSTANTS.START_LOCATION;
        this.endLocation = endLocation;
        setAssignmentId(assignmentId);
        this.successfulRoute = false;
        this.problemdescription = null;
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

    public void setStartLocation (Coordinate startLocation) {
        this.startLocation = startLocation;
    }

    public Coordinate getStartLocation() {
        return startLocation;
    }

    public Coordinate getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(Coordinate endLocation) {
        this.endLocation = endLocation;
    }

    public Long getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(Long assignmentId) {
        this.assignmentId = assignmentId;
        GetAssignmentUseCase assignmentUseCase = new GetAssignmentUseCase();
        Assignment assignment = assignmentUseCase.execute(assignmentId);
        this.vehicleId = assignment.getVehicleId();
        this.driverId = assignment.getDriverId();
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
