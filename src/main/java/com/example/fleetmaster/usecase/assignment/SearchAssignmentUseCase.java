package com.example.fleetmaster.usecase.assignment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fleetmaster.entity.assigment.model.Assignment;
import com.example.fleetmaster.entity.assigment.gateway.AssignmentGateway;

@Service
public class SearchAssignmentUseCase {
    @Autowired
    private AssignmentGateway assignmentGateway;

    public List<Assignment> execute(){
        return this.assignmentGateway.findAllByActive();
    }
    
}
