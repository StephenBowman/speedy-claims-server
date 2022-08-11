package com.allstate.speedyclaimsserver.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="claim")
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name="claim_type")
    String claimType;

    @Column(name="claim_date")
    LocalDate claimDate;

    @Column(name="estimated_amt")
    Double estimatedAmt;

    @Column(name="claim_reason")
    String claimReason;

    @Column(name="claim_description")
    String claimDescription;

    @Column(name="claim_status")
    String claimStatus;


    @Column(name="vehicle_make")
    String vehicleMake;

    @Column(name="vehicle_model")
    String vehicleModel;

    @Column(name="vehicle_year")
    String vehicleYear;


    @Column(name="animal_type")
    String animalType;

    @Column(name="animal_breed")
    String animalBreed;

    @ManyToOne()
    Customer customer;

    public Claim() {
    }

    public Claim(Integer id, String claimType, LocalDate claimDate, Double estimatedAmt,
                 String claimReason, String claimDescription, String claimStatus, String vehicleMake,
                 String vehicleModel, String vehicleYear, String animalType, String animalBreed, Customer customer) {
        this.id = id;
        this.claimType = claimType;
        this.claimDate = claimDate;
        this.estimatedAmt = estimatedAmt;
        this.claimReason = claimReason;
        this.claimDescription = claimDescription;
        this.claimStatus = claimStatus;
        this.vehicleMake = vehicleMake;
        this.vehicleModel = vehicleModel;
        this.vehicleYear = vehicleYear;
        this.animalType = animalType;
        this.animalBreed = animalBreed;
        this.customer = customer;
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

    @JsonIgnore
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCustomerName(){
        return this.customer.getName();
    }

    public String getCustomerFirstName(){
        return this.customer.getFirstName();
    }

    public int getCustomerPolicy(){
        return this.customer.getPolicyNumber();
    }
    //public Integer getCustomerId(){return this.customer.getId();};
}
