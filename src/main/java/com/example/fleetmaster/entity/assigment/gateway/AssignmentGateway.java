package com.example.fleetmaster.entity.assigment.gateway;

import java.util.List;
import java.util.Optional;

import com.example.fleetmaster.entity.assigment.model.Assignment;

public interface AssignmentGateway {

    Assignment create(Assignment assignment);
    Assignment delete(Long id);
    Assignment update(Assignment assignment, Long assignmentId);

    Optional<Assignment> findById(Long id);

    List<Assignment> findAll();

    List<Assignment> findAllByActive();

    Optional<Assignment> findByDriver(Long id);
    Optional<Assignment> findByVehicle(Long id);

    List<Assignment> findAllByDriver(Long id);
    List<Assignment> findAllByVehicle(Long id);




}
