package com.example.fleetmaster.usecase.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fleetmaster.entity.driver.exception.DriverNotFoundException;
import com.example.fleetmaster.entity.driver.gateway.DriverGateway;
import com.example.fleetmaster.entity.driver.model.Driver;

@Service
public class GetDriverCaseUse {

    @Autowired
    private DriverGateway driverGateway;

    public Driver execute(Long id) throws DriverNotFoundException{
        return this.driverGateway.findById(id).orElseThrow(DriverNotFoundException::new);
    }

}
