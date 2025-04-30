package com.example.fleetmaster.infrastructure.coordinates.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.fleetmaster.infrastructure.coordinates.dto.CoordinatePublicData;
import com.example.fleetmaster.infrastructure.coordinates.dto.CoordinateRegistrationData;
import com.example.fleetmaster.usecase.coordinates.CreateCoordinateUseCase;

import jakarta.validation.Valid;

@RestController
public class CreateCoordinateController {

    @Autowired
    private CreateCoordinateUseCase createCoordinateUseCase;

    @PostMapping("/coordinate")
    @ResponseStatus(HttpStatus.CREATED)
    public CoordinatePublicData createCoordinate(@Valid @RequestBody CoordinateRegistrationData data) {
        return new CoordinatePublicData(createCoordinateUseCase.execute(data));
    }
}
