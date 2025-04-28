package com.example.fleetmaster.infrastructure.driver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.fleetmaster.entity.driver.exception.DriverNotFoundException;
import com.example.fleetmaster.infrastructure.driver.dto.DriverPublicData;
import com.example.fleetmaster.infrastructure.driver.dto.DriverUpdateData;
import com.example.fleetmaster.usecase.driver.UpdateDriverCaseUse;

import jakarta.validation.Valid;

@RestController
public class UpdateDriverController {

    @Autowired
    private UpdateDriverCaseUse updateDriverCaseUse;

    @PutMapping("driver/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DriverPublicData updateDriver(@PathVariable Long id, @Valid @RequestBody DriverUpdateData data) throws DriverNotFoundException{
        return new DriverPublicData(updateDriverCaseUse.execute(id, data));
    }
}
