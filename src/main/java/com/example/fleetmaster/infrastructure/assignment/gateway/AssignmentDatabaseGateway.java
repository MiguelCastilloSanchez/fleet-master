package com.example.fleetmaster.infrastructure.assignment.gateway;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Component;

import com.example.fleetmaster.entity.assigment.exception.AssignmentNotFoundException;
import com.example.fleetmaster.entity.assigment.gateway.AssignmentGateway;
import com.example.fleetmaster.entity.assigment.model.Assignment;
import com.example.fleetmaster.entity.driver.exception.DriverNotFoundException;

import com.example.fleetmaster.entity.vehicle.exception.VehicleNotFoundException;

import com.example.fleetmaster.infrastructure.config.db.repository.AssignmentRepository;
import com.example.fleetmaster.infrastructure.config.db.repository.DriverRepository;
import com.example.fleetmaster.infrastructure.config.db.repository.VehicleRepository;
import com.example.fleetmaster.infrastructure.config.db.schema.AssignmentSchema;
import com.example.fleetmaster.infrastructure.config.db.schema.DriverSchema;
import com.example.fleetmaster.infrastructure.config.db.schema.VehicleSchema;
@Component
public class AssignmentDatabaseGateway implements AssignmentGateway {

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

        assignmentRepository.findByDriverAndActiveTrue(driverSchema)
        .ifPresent(a -> { throw new RuntimeException("Driver is already assigned"); });

        assignmentRepository.findByVehicleAndActiveTrue(vehicleSchema)
        .ifPresent(a -> { throw new RuntimeException("Vehicle is already assigned"); });

        return this.assignmentRepository.save(new AssignmentSchema(assignment,driverSchema,vehicleSchema)).toAssignment();
    }

    @Override
    public Assignment delete(Long id){
        
        AssignmentSchema assignmentSchema = this.assignmentRepository.findById(id).orElseThrow(AssignmentNotFoundException::new);

        assignmentSchema.setEndDate(LocalDate.now());
        assignmentSchema.setActive(false);
        return assignmentRepository.save(assignmentSchema).toAssignment();
    }

    @Override
    public Assignment update(Assignment assignment, Long id){
        AssignmentSchema currentAssignment = assignmentRepository.findById(id)
        .orElseThrow(AssignmentNotFoundException::new);

        DriverSchema driverSchema = driverRepository.findById(assignment.getDriverId())
        .orElseThrow(DriverNotFoundException::new);

        VehicleSchema vehicleSchema = vehicleRepository.findById(assignment.getVehicleId()).orElseThrow(VehicleNotFoundException::new);
        assignmentRepository.findByDriverAndActiveTrue(driverSchema).ifPresent(existing -> {
            if (!existing.getId().equals(currentAssignment.getId())) {
                throw new RuntimeException("Driver is already assigned in another assignment");
            }
        });

        assignmentRepository.findByVehicleAndActiveTrue(vehicleSchema).ifPresent(existing -> {
            if (!existing.getId().equals(currentAssignment.getId())) {
                throw new RuntimeException("Vehicle is already assigned in another assignment");
            }
        });

        currentAssignment.setActive(false);
        currentAssignment.setEndDate(LocalDate.now());
        assignmentRepository.save(currentAssignment);
    
        return this.assignmentRepository.save(new AssignmentSchema(assignment,driverSchema,vehicleSchema)).toAssignment();
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

    @Override
    public List<Assignment> findAllByActive(){
        return assignmentRepository.findAllByActive(true).stream().map(AssignmentSchema::toAssignment).toList();
    }

    @Override
    public Optional<Assignment> findByDriver(Long id){
        DriverSchema driverSchema = driverRepository.findById(id)
        .orElseThrow(DriverNotFoundException::new);
        return assignmentRepository.findByDriverAndActiveTrue(driverSchema).map(AssignmentSchema::toAssignment);
    }

    @Override
    public Optional<Assignment> findByVehicle(Long id){
        VehicleSchema vehicleSchema = vehicleRepository.findById(id)
        .orElseThrow(VehicleNotFoundException::new);
        return assignmentRepository.findByVehicleAndActiveTrue(vehicleSchema).map(AssignmentSchema::toAssignment);
    }

    @Override
    public List<Assignment> findAllByDriver(Long id){
        DriverSchema driverSchema = driverRepository.findById(id)
        .orElseThrow(DriverNotFoundException::new);
        return assignmentRepository.findAllByDriverOrderByStartDateDesc(driverSchema).stream().map(AssignmentSchema::toAssignment).toList();
    }

    @Override
    public List<Assignment> findAllByVehicle(Long id){
        VehicleSchema vehicleSchema = vehicleRepository.findById(id)
        .orElseThrow(VehicleNotFoundException::new);
        return assignmentRepository.findAllByVehicleOrderByStartDateDesc(vehicleSchema).stream().map(AssignmentSchema::toAssignment).toList();
    }


    
}
