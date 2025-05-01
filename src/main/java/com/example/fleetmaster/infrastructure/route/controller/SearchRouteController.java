package com.example.fleetmaster.infrastructure.route.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.fleetmaster.infrastructure.route.dto.RoutePublicData;
import com.example.fleetmaster.usecase.route.SearchRouteUseCase;
import com.example.fleetmaster.entity.route.model.Route;

import java.util.List;

@RestController
public class SearchRouteController {

    @Autowired
    private SearchRouteUseCase searchRouteUseCase;

    @GetMapping("/route")
    @ResponseStatus(HttpStatus.OK)
    public List<RoutePublicData> searchRoutes() {
        List <Route> routes = searchRouteUseCase.execute();

        return routes.stream().map(RoutePublicData::new).toList();
    }
}
