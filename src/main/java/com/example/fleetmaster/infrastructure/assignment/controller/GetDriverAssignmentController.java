package com.example.fleetmaster.infrastructure.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.fleetmaster.infrastructure.assignment.dto.AssignmentPublicData;
import com.example.fleetmaster.usecase.assignment.GetDriverAssignmentUseCase;

@RestController
public class GetDriverAssignmentController {
    @Autowired
    GetDriverAssignmentUseCase getDriverAssignmentUseCase;

    @GetMapping("/assignment/driver/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AssignmentPublicData getDriverAssignment(@PathVariable Long id){
        return new AssignmentPublicData(getDriverAssignmentUseCase.execute(id));

    }
    

}
