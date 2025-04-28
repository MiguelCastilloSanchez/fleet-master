package com.example.fleetmaster.infrastructure.config.db.schema;

import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.*;
import java.time.LocalDate;

import com.example.fleetmaster.entity.driver.model.Driver;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Drivers")
public class DriverSchema extends AbstractEntitySchema<Long>{
    
    @NotBlank
    @Column(length = 20, nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate birthDate;

    @NotBlank
    @Column(length = 18, unique = true, nullable = false)
    private String curp;

    @NotBlank
    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private double salary;

    @Column(unique = true, nullable = false)
    private Long licenseNumber;

    @Column(nullable = false)
    private LocalDate systemEntryDate;

    public DriverSchema(String name, LocalDate birthDate, String curp, String address, double salary, Long licenseNumber, LocalDate systemEntryDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.curp = curp;
        this.address = address;
        this.salary = salary;
        this.licenseNumber = licenseNumber;
        this.systemEntryDate = systemEntryDate;
    }

    public DriverSchema(){

    }

    public DriverSchema(Driver driver){
        this.name = driver.getName();
        this.birthDate = driver.getBirthDate();
        this.curp = driver.getCurp();
        this.address = driver.getAddress();
        this.salary = driver.getSalary();
        this.licenseNumber = driver.getLicenseNumber();
        this.systemEntryDate = driver.getSystemEntryDate();
    }

    public DriverSchema(Long id, String name, LocalDate birthDate, String curp, String address, double salary, Long licenseNumber, LocalDate systemEntryDate) {
        this.setId(id);
        this.name = name;
        this.birthDate = birthDate;
        this.curp = curp;
        this.address = address;
        this.salary = salary;
        this.licenseNumber = licenseNumber;
        this.systemEntryDate = systemEntryDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Long getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(Long licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public LocalDate getSystemEntryDate() {
        return systemEntryDate;
    }

    public void setSystemEntryDate(LocalDate systemEntryDate) {
        this.systemEntryDate = systemEntryDate;
    }

    public Driver toDriver(){
        Driver driver = new Driver(
            this.getName(),
            this.getBirthDate(),
            this.getCurp(),
            this.getAddress(),
            this.getSalary(),
            this.getLicenseNumber(),
            this.getSystemEntryDate()
        );

        driver.setId(this.getId());

        return driver;
    }

    public void updateDriver(Driver driver){
        this.name = driver.getName();
        this.birthDate = driver.getBirthDate();
        this.curp = driver.getCurp();
        this.address = driver.getAddress();
        this.salary = driver.getSalary();
        this.licenseNumber = driver.getLicenseNumber();
        this.systemEntryDate = driver.getSystemEntryDate();
    }
}
