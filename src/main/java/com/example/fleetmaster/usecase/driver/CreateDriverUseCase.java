package com.example.fleetmaster.usecase.driver;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fleetmaster.entity.driver.gateway.DriverGateway;
import com.example.fleetmaster.entity.driver.model.Driver;
import com.example.fleetmaster.usecase.driver.dto.IDriverRegistrationData;

@Service
public class CreateDriverUseCase {

    @Autowired
    private DriverGateway driverGateway;

    public Driver execute(IDriverRegistrationData data){
        Driver driver = new Driver(data.name(), data.birthDate(), data.curp(), data.address(), data.salary(), data.licenseNumber(), LocalDate.now());
        return this.driverGateway.create(driver);
    }
    
}
