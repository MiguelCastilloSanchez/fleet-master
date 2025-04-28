package com.example.fleetmaster.infrastructure.config.db.repository;

import java.util.Optional;
import java.time.LocalDate;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fleetmaster.infrastructure.config.db.schema.DriverSchema;

@Repository
public interface DriverRepository extends JpaRepository<DriverSchema, Long>{

    Optional<DriverSchema> findByName(String name);
    Optional<DriverSchema> findByBirthDate(LocalDate birthDate);
    Optional<DriverSchema> findByCurp(String curp);
    Optional<DriverSchema> findByAddress(String address);
    Optional<DriverSchema> findBySalary(double salary);
    Optional<DriverSchema> findByLicenseNumber(Long licenseNumber);
    Optional<DriverSchema> findBySystemEntryDate(LocalDate systemEntryDate);

    Collection<DriverSchema> findAllByName(String name);
    Collection<DriverSchema> findAllByBirthDate(LocalDate birthDate);
    Collection<DriverSchema> findAllByCurp(String curp);
    Collection<DriverSchema> findAllByAddress(String address);
    Collection<DriverSchema> findAllBySalary(double salary);
    Collection<DriverSchema> findAllByLicenseNumber(Long licenseNumber);
    Collection<DriverSchema> findAllBySystemEntryDate(LocalDate systemEntryDate);
    
}
