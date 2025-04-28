package com.example.fleetmaster.infrastructure.driver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.fleetmaster.infrastructure.driver.dto.DriverPublicData;
import com.example.fleetmaster.infrastructure.driver.dto.DriverRegistrationData;
import com.example.fleetmaster.usecase.driver.CreateDriverUseCase;

import jakarta.validation.Valid;

@RestController
public class CreateDriverController {
    
    @Autowired
    private CreateDriverUseCase createDriverUseCase;

    @PostMapping("/driver")
    @ResponseStatus(HttpStatus.CREATED)
    public DriverPublicData createDriver(@Valid @RequestBody DriverRegistrationData data){
        return new DriverPublicData(createDriverUseCase.execute(data));
    }
}
