package com.example.fleetmaster.infrastructure.coordinates.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.fleetmaster.entity.coordinates.exception.CoordinateNotFoundException;
import com.example.fleetmaster.infrastructure.coordinates.dto.CoordinatePublicData;
import com.example.fleetmaster.usecase.coordinates.GetCoordinateUseCase;

@RestController
public class GetCoordinateController {

    @Autowired
    private GetCoordinateUseCase getCoordinateUseCase;

    @GetMapping("/coordinate/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CoordinatePublicData getCoordinate(@PathVariable Long id) throws CoordinateNotFoundException {
        return new CoordinatePublicData(getCoordinateUseCase.execute(id));
    }

}
