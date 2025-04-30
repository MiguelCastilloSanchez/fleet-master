package com.example.fleetmaster.infrastructure.route.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.fleetmaster.entity.route.exception.RouteNotFoundException;
import com.example.fleetmaster.infrastructure.route.dto.RoutePublicData;
import com.example.fleetmaster.infrastructure.route.dto.RouteUpdateData;
import com.example.fleetmaster.usecase.route.UpdateRouteUseCase;

import jakarta.validation.Valid;

@RestController
public class UpdateRouteController {

    @Autowired
    private UpdateRouteUseCase updateRouteUseCase;

    @PutMapping("/route/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RoutePublicData updateRoute(@PathVariable Long id, @Valid @RequestBody RouteUpdateData data) throws RouteNotFoundException {
        return new RoutePublicData(updateRouteUseCase.execute(id, data));
    }

}
