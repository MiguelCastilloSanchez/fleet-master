package com.example.fleetmaster.infrastructure.route.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.fleetmaster.entity.route.exception.RouteNotFoundException;
import com.example.fleetmaster.infrastructure.route.dto.RoutePublicData;
import com.example.fleetmaster.usecase.route.GetRouteUseCase;

@RestController
public class GetRouteController {

    @Autowired
    private GetRouteUseCase getRouteUseCase;

    @GetMapping("/route/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RoutePublicData getRoute(@PathVariable Long id) throws RouteNotFoundException {
        return new RoutePublicData(getRouteUseCase.execute(id));
    }
}
