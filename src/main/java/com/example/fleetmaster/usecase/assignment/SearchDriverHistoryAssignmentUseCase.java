package com.example.fleetmaster.usecase.assignment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fleetmaster.entity.assigment.gateway.AssignmentGateway;
import com.example.fleetmaster.entity.assigment.model.Assignment;
@Service
public class SearchDriverHistoryAssignmentUseCase {
    @Autowired
    private AssignmentGateway assignmentGateway;

    public List<Assignment> execute(Long id){
        return this.assignmentGateway.findAllByDriver(id);
    }
}
