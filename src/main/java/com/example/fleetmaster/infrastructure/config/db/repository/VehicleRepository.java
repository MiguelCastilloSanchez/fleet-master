package com.example.fleetmaster.infrastructure.config.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.fleetmaster.infrastructure.config.db.schema.VehicleSchema;
import java.util.Optional;
import java.time.LocalDate;
import java.util.Collection;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleSchema,Long>{
    Optional<VehicleSchema> findByBrand(String brand);

    Optional<VehicleSchema> findByVin(String vin);

    Optional<VehicleSchema> findByPlate(String plate);

    Optional<VehicleSchema> findByPurchaseDate(LocalDate purchaseDate);

    Optional<VehicleSchema> findByCost(Double cost);

    Optional<VehicleSchema> findByPhotoUrl(String photoUrl);

    Optional<VehicleSchema> findByRegistrationDate(LocalDate registrationDate);


    Collection<VehicleSchema> findAllByBrand(String brand);

    Collection<VehicleSchema> findAllByVin(String vin);

    Collection<VehicleSchema> findAllByPlate(String plate);

    Collection<VehicleSchema> findAllByPurchaseDate(LocalDate purchaseDate);

    Collection<VehicleSchema> findAllByCost(Double cost);

    Collection<VehicleSchema> findAllByPhotoUrl(String photoUrl);
    
    Collection<VehicleSchema> findAllByRegistrationDate(LocalDate registrationDate);
}
