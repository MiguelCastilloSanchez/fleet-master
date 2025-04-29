package com.example.fleetmaster.infrastructure.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.fleetmaster.infrastructure.assignment.dto.AssignmentPublicData;
import com.example.fleetmaster.infrastructure.assignment.dto.AssignmentRegistrationData;
import com.example.fleetmaster.usecase.assignment.UpdateAssignmentUseCase;

import jakarta.validation.Valid;

@RestController
public class UpdateAssignmentController {
    
    @Autowired
    UpdateAssignmentUseCase updateAssignmentUseCase;

    @PutMapping("/assignment/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AssignmentPublicData updateAssignment(@PathVariable Long id, @Valid @RequestBody AssignmentRegistrationData data){
        return new AssignmentPublicData(updateAssignmentUseCase.execute(id, data));
    }
}
