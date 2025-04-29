package com.example.fleetmaster.entity.assigment.gateway;

import java.util.List;
import java.util.Optional;

import com.example.fleetmaster.entity.assigment.model.Assignment;

public interface AssignmentGateway {

    Assignment create(Assignment assignment);
    Assignment delete(Long id);

    Optional<Assignment> findById(Long id);

    List<Assignment> findAll();
    
}
