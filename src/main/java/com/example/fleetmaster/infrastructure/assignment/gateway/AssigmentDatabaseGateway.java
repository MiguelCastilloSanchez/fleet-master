package com.example.fleetmaster.infrastructure.assignment.gateway;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.fleetmaster.entity.assigment.exception.AssignmentNotFoundException;
import com.example.fleetmaster.entity.assigment.gateway.AssignmentGateway;
import com.example.fleetmaster.entity.assigment.model.Assignment;
import com.example.fleetmaster.entity.driver.exception.DriverNotFoundException;
import com.example.fleetmaster.entity.driver.model.Driver;
import com.example.fleetmaster.entity.vehicle.exception.VehicleNotFoundException;
import com.example.fleetmaster.entity.vehicle.model.Vehicle;
import com.example.fleetmaster.infrastructure.config.db.repository.AssignmentRepository;
import com.example.fleetmaster.infrastructure.config.db.repository.DriverRepository;
import com.example.fleetmaster.infrastructure.config.db.repository.VehicleRepository;
import com.example.fleetmaster.infrastructure.config.db.schema.AssignmentSchema;
import com.example.fleetmaster.infrastructure.config.db.schema.DriverSchema;
import com.example.fleetmaster.infrastructure.config.db.schema.VehicleSchema;
@Component
public class AssigmentDatabaseGateway implements AssignmentGateway {

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired 
    private VehicleRepository vehicleRepository;

    @Override
    public Assignment create(Assignment assignment){

        DriverSchema driverSchema = driverRepository.findById(assignment.getDriverId())
        .orElseThrow(DriverNotFoundException::new);

        VehicleSchema vehicleSchema = vehicleRepository.findById(assignment.getVehicleId()).orElseThrow(VehicleNotFoundException::new);

        return this.assignmentRepository.save(new AssignmentSchema(assignment,driverSchema,vehicleSchema)).toAssignment();
    }

    @Override
    public void delete(Long id) {
        
        AssignmentSchema assignmentSchema = this.assignmentRepository.findById(id).orElseThrow(AssignmentNotFoundException::new);

        assignmentSchema.setEndDate(LocalDate.now());
        assignmentSchema.setActive(false);
    }

    @Override
    public Optional<Assignment> findById(Long id) {
        return assignmentRepository
                .findById(id)
                .map(AssignmentSchema::toAssignment);
    }


    @Override
    public List<Assignment> findAll(){
        return assignmentRepository
        .findAll().stream().map(AssignmentSchema::toAssignment)
        .toList();
    }
    
}
