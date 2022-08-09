package com.allstate.speedyclaimsserver.service;

import com.allstate.speedyclaimsserver.domain.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAll();
    int countCustomers();
    List<Customer> findByName(String name);
    List<Customer> findByPolicyNumber(Integer policy);
}
