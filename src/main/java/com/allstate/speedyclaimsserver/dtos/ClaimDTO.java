package com.allstate.speedyclaimsserver.dtos;

import com.allstate.speedyclaimsserver.domain.Claim;
import com.allstate.speedyclaimsserver.domain.Customer;
import java.time.LocalDate;

public class ClaimDTO {

    Integer id;

    String claimType;
    LocalDate claimDate;
    Double estimatedAmt;
    String claimReason;
    String claimDescription;
    String claimStatus;

    String vehicleMake;
    String vehicleModel;
    String vehicleYear;

    String animalType;
    String animalBreed;

    Customer customer;

    public ClaimDTO(){}

    public ClaimDTO(Claim claim){
        this.claimType = claim.getClaimType();
        this.claimDate = claim.getClaimDate();
        this.estimatedAmt = claim.getEstimatedAmt();
        this.claimReason = claim.getClaimReason();
        this.claimDescription = claim.getClaimDescription();
        this.claimStatus = claim.getClaimStatus();

        this.vehicleMake = claim.getVehicleMake();
        this.vehicleModel = claim.getVehicleModel();
        this.vehicleYear = claim.getVehicleYear();

        this.animalType = claim.getAnimalType();
        this.animalBreed = claim.getAnimalBreed();

        this.customer = claim.getCustomer();
    }

    public Claim toClaim(){
        return new Claim(null, claimType, claimDate, estimatedAmt, claimReason, claimDescription, claimStatus,
                vehicleMake, vehicleModel, vehicleYear, animalType, animalBreed, customer);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
