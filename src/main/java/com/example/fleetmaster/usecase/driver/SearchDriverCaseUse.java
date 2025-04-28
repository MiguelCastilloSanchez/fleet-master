package com.example.fleetmaster.usecase.driver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fleetmaster.entity.driver.gateway.DriverGateway;
import com.example.fleetmaster.entity.driver.model.Driver;

@Service
public class SearchDriverCaseUse {
    
    @Autowired
    private DriverGateway driverGateway;

    public List<Driver> execute(){
        return this.driverGateway.findAll();
    }

    
}
