package com.allstate.speedyclaimsserver.domain;

import java.util.List;

public class Customers {

    int id;

    int policyNumber;
    String firstName;
    String surName;
    String addressCity;
    String addressStreet1;
    String addressStreet2;
    String addressPostCode;

    List<Claim> claims;

    public Customers() {
    }

    public Customers(int id, int policyNumber, String firstName, String surName,
                     String addressCity, String addressStreet1, String addressStreet2,
                     String addressPostCode, List<Claim> claims) {
        this.id = id;
        this.policyNumber = policyNumber;
        this.firstName = firstName;
        this.surName = surName;
        this.addressCity = addressCity;
        this.addressStreet1 = addressStreet1;
        this.addressStreet2 = addressStreet2;
        this.addressPostCode = addressPostCode;
        this.claims = claims;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public List<Claim> getClaims() {
        return claims;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressStreet1() {
        return addressStreet1;
    }

    public void setAddressStreet1(String addressStreet1) {
        this.addressStreet1 = addressStreet1;
    }

    public String getAddressStreet2() {
        return addressStreet2;
    }

    public void setAddressStreet2(String addressStreet2) {
        this.addressStreet2 = addressStreet2;
    }

    public String getAddressPostCode() {
        return addressPostCode;
    }

    public void setAddressPostCode(String addressPostCode) {
        this.addressPostCode = addressPostCode;
    }

    public void setClaims(List<Claim> claims) {
        this.claims = claims;
    }
}

