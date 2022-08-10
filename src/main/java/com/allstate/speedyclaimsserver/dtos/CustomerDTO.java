package com.allstate.speedyclaimsserver.dtos;

import com.allstate.speedyclaimsserver.domain.Claim;
import com.allstate.speedyclaimsserver.domain.Customer;

import javax.persistence.Column;
import java.sql.Array;
import java.util.ArrayList;

public class CustomerDTO {

    int policyNumber;
    String firstName;
    String name;
    String addressCity;
    String addressStreet1;
    String addressStreet2;
    String addressPostCode;

    public CustomerDTO(){

    }

    public CustomerDTO(Customer customer){
        this.policyNumber = customer.getPolicyNumber();
        this.firstName = customer.getFirstName();
        this.name = customer.getName();
        this.addressCity = customer.getAddressCity();
        this.addressStreet1 = customer.getAddressStreet1();
        this.addressStreet2 = customer.getAddressStreet2();
        this.addressPostCode = customer.getAddressPostCode();
    }

    public Customer toCustomer(){
        return new Customer(null, policyNumber, firstName, name, addressCity, addressStreet1,
                addressStreet2, addressPostCode, new ArrayList<>());
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
