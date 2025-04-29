package com.example.fleetmaster.infrastructure.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.fleetmaster.entity.assigment.exception.AssignmentNotFoundException;
import com.example.fleetmaster.infrastructure.assignment.dto.AssignmentPublicData;
import com.example.fleetmaster.usecase.assignment.GetAssignmentUseCase;

@RestController
public class GetAssignmentController {
    
    @Autowired
    private GetAssignmentUseCase getAssignmentUseCase;

    @GetMapping("/assignment/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AssignmentPublicData getAssignment(@PathVariable Long id) throws AssignmentNotFoundException{
        return new AssignmentPublicData(getAssignmentUseCase.execute(id));
    }
}
