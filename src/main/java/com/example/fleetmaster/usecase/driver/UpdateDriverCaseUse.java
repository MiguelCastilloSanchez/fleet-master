package com.example.fleetmaster.usecase.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fleetmaster.entity.driver.exception.DriverNotFoundException;
import com.example.fleetmaster.entity.driver.gateway.DriverGateway;
import com.example.fleetmaster.entity.driver.model.Driver;
import com.example.fleetmaster.usecase.driver.dto.IDriverUpdateData;

@Service
public class UpdateDriverCaseUse {

    @Autowired
    private DriverGateway driverGateway;

    public Driver execute(Long id, IDriverUpdateData data) throws DriverNotFoundException{
        Driver driver = this.driverGateway.findById(id).orElseThrow(DriverNotFoundException::new);

        if(data.address() != null && !data.address().isBlank()){
            driver.setAddress(data.address());
        }

        if(data.salary() > 0){
            driver.setSalary(data.salary());
        }

        return this.driverGateway.update(driver);
    }
    
}
