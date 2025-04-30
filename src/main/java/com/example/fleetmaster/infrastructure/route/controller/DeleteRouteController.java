package com.example.fleetmaster.infrastructure.route.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.fleetmaster.entity.route.exception.RouteNotFoundException;
import com.example.fleetmaster.infrastructure.route.dto.RoutePublicData;
import com.example.fleetmaster.usecase.route.DeleteRouteUseCase;

@RestController

public class DeleteRouteController {

    @Autowired
    private DeleteRouteUseCase deleteRouteUseCase;

    @DeleteMapping("/route/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RoutePublicData deleteRoute(@PathVariable Long id) throws RouteNotFoundException {
        return new RoutePublicData(deleteRouteUseCase.execute(id));
    }

}
