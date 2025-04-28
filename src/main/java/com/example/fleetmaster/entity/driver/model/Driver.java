package com.example.fleetmaster.entity.driver.model;

import java.time.LocalDate;

import com.example.fleetmaster.entity.AbstractEntity;

public class Driver extends AbstractEntity<Long>{
    private String name;
    private LocalDate birthDate;
    private String curp;
    private String address;
    private double salary;
    private long licenseNumber;
    private LocalDate systemEntryDate;

    public Driver(String name, LocalDate birthDate, String curp, String address, double salary, long licenseNumber, LocalDate systemEntryDate) {
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

    public long getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(long licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public LocalDate getSystemEntryDate() {
        return systemEntryDate;
    }

    public void setSystemEntryDate(LocalDate systemEntryDate) {
        this.systemEntryDate = systemEntryDate;
    }

    
}
