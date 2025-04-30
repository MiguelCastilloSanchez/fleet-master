package com.example.fleetmaster.infrastructure.config.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fleetmaster.infrastructure.config.db.schema.CoordinateSchema;
import java.util.Optional;

@Repository
public interface CoordinateRepository extends JpaRepository<CoordinateSchema, Long> {

    Optional<CoordinateSchema> findById(Long id);

    Optional<CoordinateSchema> findByName(String name);
}
