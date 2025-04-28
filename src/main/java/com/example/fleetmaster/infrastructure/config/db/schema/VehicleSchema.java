package com.example.fleetmaster.infrastructure.config.db.schema;



import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.*;

import java.time.LocalDate;

import com.example.fleetmaster.entity.vehicle.model.Vehicle;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Vehicles")
public class VehicleSchema extends AbstractEntitySchema<Long>{
    
    @NotBlank
    @Column(length = 15, nullable = false)
    private String brand;

    @NotBlank
    @Column(length = 17, nullable = false, unique = true)
    private String vin;

    @NotBlank
    @Column(length = 10, nullable = false)
    private String plate;

    @Column(nullable = false)
    private LocalDate purchaseDate;

    @Column(nullable = false)
    private double cost;

    @NotBlank
    @Column(nullable = true)
    private String photoUrl;

    @Column(nullable = false)
    private LocalDate registrationDate;

    public VehicleSchema(String brand, String vin, String plate, LocalDate purchaseDate, double cost, String photoUrl, LocalDate registrationDate){
        this.brand = brand;
        this.vin = vin;
        this.plate = plate;
        this.purchaseDate = purchaseDate;
        this.cost = cost;
        this.photoUrl = photoUrl;
        this.registrationDate = registrationDate;
    }

    public VehicleSchema(){

    }

    public VehicleSchema(Vehicle vehicle){
        this.brand = vehicle.getBrand();
        this.vin = vehicle.getVin();
        this.plate = vehicle.getPlate();
        this.purchaseDate = vehicle.getPurchaseDate();
        this.cost = vehicle.getCost();
        this.photoUrl = vehicle.getPhotoUrl();
        this.registrationDate = vehicle.getRegistrationDate();
    }

    public VehicleSchema(Long id, String brand, String vin, String plate, LocalDate purchaseDate, double cost, String photoUrl, LocalDate registrationDate){
        this.setId(id);
        this.brand = brand;
        this.vin = vin;
        this.plate = plate;
        this.purchaseDate = purchaseDate;
        this.cost = cost;
        this.photoUrl = photoUrl;
        this.registrationDate = registrationDate;
    }

    public String getBrand() {
        return brand;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    public String getVin() {
        return vin;
    }
    
    public void setVin(String vin) {
        this.vin = vin;
    }
    
    public String getPlate() {
        return plate;
    }
    
    public void setPlate(String plate) {
        this.plate = plate;
    }
    
    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }
    
    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public double getCost(){
        return cost;
    }

    public void setCost(double cost){
        this.cost = cost;
    }
    
    public String getPhotoUrl() {
        return photoUrl;
    }
    
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
    
    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate){
        this.registrationDate = registrationDate;
    }

    public Vehicle toVehicle(){
        Vehicle vehicle = new Vehicle(
            this.getBrand(),
            this.getVin(),
            this.getPlate(),
            this.getPurchaseDate(),
            this.getCost(),
            this.getPhotoUrl(),
            this.getRegistrationDate()
        );
        
        vehicle.setId(this.getId());

        return vehicle;
    }

    public void updateVehicle(Vehicle vehicle){
        this.brand = vehicle.getBrand();
        this.vin = vehicle.getVin();
        this.plate = vehicle.getPlate();
        this.purchaseDate = vehicle.getPurchaseDate();
        this.cost = vehicle.getCost();
        this.photoUrl = vehicle.getPhotoUrl();
        this.registrationDate = vehicle.getRegistrationDate();
        
    }

}
