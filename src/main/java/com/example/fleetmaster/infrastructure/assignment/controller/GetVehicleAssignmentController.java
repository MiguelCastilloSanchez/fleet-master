package com.example.fleetmaster.infrastructure.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.fleetmaster.infrastructure.assignment.dto.AssignmentPublicData;
import com.example.fleetmaster.usecase.assignment.GetVehicleAssignmentUseCase;

@RestController
public class GetVehicleAssignmentController {
     @Autowired
    GetVehicleAssignmentUseCase getVehicleAssignmentUseCase;

    @GetMapping("/assignment/vehicle/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AssignmentPublicData getVehicleAssignment(@PathVariable Long id){
        return new AssignmentPublicData(getVehicleAssignmentUseCase.execute(id));

    }
}
