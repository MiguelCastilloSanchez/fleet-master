package com.example.fleetmaster.usecase.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fleetmaster.entity.assigment.exception.AssignmentNotFoundException;
import com.example.fleetmaster.entity.assigment.gateway.AssignmentGateway;
import com.example.fleetmaster.entity.assigment.model.Assignment;

@Service
public class DeleteAssignmentUseCase {
    @Autowired
    private AssignmentGateway assignmentGateway;

    public Assignment execute(Long id) throws AssignmentNotFoundException{

        Assignment deletedAssignment = assignmentGateway.delete(id);
        
        return deletedAssignment;
    }
}
