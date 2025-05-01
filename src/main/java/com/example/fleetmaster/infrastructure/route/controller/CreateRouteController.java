package com.example.fleetmaster.infrastructure.route.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.fleetmaster.infrastructure.route.dto.RoutePublicData;
import com.example.fleetmaster.infrastructure.route.dto.RouteRegistrationData;
import com.example.fleetmaster.usecase.route.CreateRouteUseCase;

import jakarta.validation.Valid;

@RestController
public class CreateRouteController {

    @Autowired
    private CreateRouteUseCase createRouteUseCase;

    @PostMapping("/route")
    @ResponseStatus(HttpStatus.CREATED)
    public RoutePublicData createRoute(@Valid @RequestBody RouteRegistrationData data) {
        return new RoutePublicData(createRouteUseCase.execute(data));
    }
}
