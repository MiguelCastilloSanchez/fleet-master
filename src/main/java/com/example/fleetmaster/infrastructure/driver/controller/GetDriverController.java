package com.example.fleetmaster.infrastructure.driver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.fleetmaster.entity.driver.exception.DriverNotFoundException;
import com.example.fleetmaster.infrastructure.driver.dto.DriverPublicData;
import com.example.fleetmaster.usecase.driver.GetDriverCaseUse;

@RestController
public class GetDriverController {
    
    @Autowired
    private GetDriverCaseUse getDriverCaseUse;

    @GetMapping("/driver/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DriverPublicData getDriver(@PathVariable Long id) throws DriverNotFoundException{
        return new DriverPublicData(getDriverCaseUse.execute(id));
    }
}
