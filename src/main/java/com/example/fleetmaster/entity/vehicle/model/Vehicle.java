package com.example.fleetmaster.entity.vehicle.model;
import java.time.LocalDate;

import com.example.fleetmaster.entity.AbstractEntity;

public class Vehicle extends AbstractEntity<Long>{
    
    private String brand;
    private String vin;
    private String plate;
    private LocalDate purchaseDate;
    private double cost;
    private String photoUrl;
    private LocalDate registrationDate;

    public Vehicle(String brand, String vin, String plate, LocalDate purchaseDate, Double cost, String photoUrl, LocalDate registrationDate){
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
        return this.cost;
    }

    public void setCost(Double cost){
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
    
}
