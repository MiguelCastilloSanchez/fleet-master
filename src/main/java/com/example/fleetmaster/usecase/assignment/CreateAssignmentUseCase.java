package com.example.fleetmaster.usecase.assignment;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fleetmaster.entity.assigment.gateway.AssignmentGateway;
import com.example.fleetmaster.entity.assigment.model.Assignment;
import com.example.fleetmaster.usecase.assignment.dto.IAssignmentRegistrationData;

@Service
public class CreateAssignmentUseCase {
    
    @Autowired
    private AssignmentGateway assignmentGateway;

    public Assignment execute(IAssignmentRegistrationData data){
        Assignment assignment = new Assignment(data.driverId(), data.vehicleId(), LocalDate.now());
        return this.assignmentGateway.create(assignment);
    }
    
}
