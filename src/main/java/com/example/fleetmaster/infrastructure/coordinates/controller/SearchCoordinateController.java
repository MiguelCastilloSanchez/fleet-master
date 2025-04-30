package com.example.fleetmaster.infrastructure.coordinates.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.fleetmaster.infrastructure.coordinates.dto.CoordinatePublicData;
import com.example.fleetmaster.usecase.coordinates.SearchCoordinateUseCase;
import com.example.fleetmaster.entity.coordinates.model.Coordinate;

import java.util.List;

@RestController
public class SearchCoordinateController {

    @Autowired
    private SearchCoordinateUseCase searchCoordinateUseCase;

    @GetMapping("/coordinate")
    @ResponseStatus(HttpStatus.OK)
    public List<CoordinatePublicData> searchCoordinates() {
        List <Coordinate> coordinates = searchCoordinateUseCase.execute();

        return coordinates.stream().map(CoordinatePublicData::new).toList();
    }
}
