package com.allstate.speedyclaimsserver.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name="policy_number")
    int policyNumber;

    @Column(name="first_name")
    String firstName;

    @Column(name="name")
    String name;

    @Column(name="address_city")
    String addressCity;

    @Column(name="address_street1")
    String addressStreet1;

    @Column(name="address_street2")
    String addressStreet2;

    @Column(name="address_post_code")
    String addressPostCode;

    @OneToMany(cascade = CascadeType.ALL)
    List<Claim> claims;

    public Customer() {
    }

    public Customer(Integer id, int policyNumber, String firstName, String name, String addressCity,
                    String addressStreet1, String addressStreet2, String addressPostCode, List<Claim> claims) {
        this.id = id;
        this.policyNumber = policyNumber;
        this.firstName = firstName;
        this.name = name;
        this.addressCity = addressCity;
        this.addressStreet1 = addressStreet1;
        this.addressStreet2 = addressStreet2;
        this.addressPostCode = addressPostCode;
        this.claims = claims;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public List<Claim> getClaims() {
        return claims;
    }

    public void setClaims(List<Claim> claims) {
        this.claims = claims;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", policyNumber=" + policyNumber +
                ", firstName='" + firstName + '\'' +
                ", name='" + name + '\'' +
                ", addressCity='" + addressCity + '\'' +
                ", addressStreet1='" + addressStreet1 + '\'' +
                ", addressStreet2='" + addressStreet2 + '\'' +
                ", addressPostCode='" + addressPostCode + '\'' +
                ", claims=" + claims +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer that = (Customer) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

