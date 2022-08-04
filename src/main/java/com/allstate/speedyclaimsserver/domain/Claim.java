package com.allstate.speedyclaimsserver.domain;

import java.time.LocalDate;

public class Claim {

    String claimType;
    LocalDate claimDate;
    Double estimatedAmt;
    String claimReason;
    String claimDescription;

    String vehicleMake;
    String vehicleModel;
    String vehicleYear;

    String animalType;
    String animalBreed;

    Customers customer;

    public Claim() {
    }

    public Claim(String claimType, LocalDate claimDate, Double estimatedAmt, String claimReason,
                 String claimDescription, String vehicleMake, String vehicleModel, String vehicleYear,
                 String animalType, String animalBreed, Customers customer) {
        this.claimType = claimType;
        this.claimDate = claimDate;
        this.estimatedAmt = estimatedAmt;
        this.claimReason = claimReason;
        this.claimDescription = claimDescription;
        this.vehicleMake = vehicleMake;
        this.vehicleModel = vehicleModel;
        this.vehicleYear = vehicleYear;
        this.animalType = animalType;
        this.animalBreed = animalBreed;
        this.customer = customer;
    }

    public String getClaimType() {
        return claimType;
    }

    public void setClaimType(String claimType) {
        this.claimType = claimType;
    }

    public LocalDate getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(LocalDate claimDate) {
        this.claimDate = claimDate;
    }

    public Double getEstimatedAmt() {
        return estimatedAmt;
    }

    public void setEstimatedAmt(Double estimatedAmt) {
        this.estimatedAmt = estimatedAmt;
    }

    public String getClaimReason() {
        return claimReason;
    }

    public void setClaimReason(String claimReason) {
        this.claimReason = claimReason;
    }

    public String getClaimDescription() {
        return claimDescription;
    }

    public void setClaimDescription(String claimDescription) {
        this.claimDescription = claimDescription;
    }

    public String getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(String vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleYear() {
        return vehicleYear;
    }

    public void setVehicleYear(String vehicleYear) {
        this.vehicleYear = vehicleYear;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getAnimalBreed() {
        return animalBreed;
    }

    public void setAnimalBreed(String animalBreed) {
        this.animalBreed = animalBreed;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }
}
