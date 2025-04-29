package com.example.fleetmaster.infrastructure.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.fleetmaster.infrastructure.assignment.dto.AssigmentRegistrationData;
import com.example.fleetmaster.infrastructure.assignment.dto.AssignmentPublicData;
import com.example.fleetmaster.usecase.assignment.CreateAssignmentUseCase;

import jakarta.validation.Valid;

@RestController
public class CreateAssigmentController {

    @Autowired
    private CreateAssignmentUseCase createAssignmentUseCase;

    @PostMapping("/assignment")
    @ResponseStatus(HttpStatus.CREATED)
    public AssignmentPublicData createAssigment(@Valid @RequestBody AssigmentRegistrationData data){
        return new AssignmentPublicData(createAssignmentUseCase.execute(data));
    }
    
}
