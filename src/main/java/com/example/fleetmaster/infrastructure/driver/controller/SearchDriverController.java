package com.example.fleetmaster.infrastructure.driver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.fleetmaster.entity.driver.exception.DriverNotFoundException;
import com.example.fleetmaster.entity.driver.model.Driver;
import com.example.fleetmaster.infrastructure.driver.dto.DriverPublicData;
import com.example.fleetmaster.usecase.driver.SearchDriverCaseUse;

@RestController
public class SearchDriverController {
    
    @Autowired
    private SearchDriverCaseUse searchDriverCaseUse;

    @PutMapping("/driver")
    @ResponseStatus(HttpStatus.OK)
    public List<DriverPublicData> searchDriver(@PathVariable Long id) throws DriverNotFoundException{
        List<Driver> drivers = this.searchDriverCaseUse.execute();

        return drivers.stream().map(DriverPublicData::new).toList();
    }
    
}
