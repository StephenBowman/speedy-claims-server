package com.allstate.speedyclaimsserver.service;

import com.allstate.speedyclaimsserver.domain.Customer;
import com.allstate.speedyclaimsserver.dtos.CustomerDTO;

import java.util.List;
import java.util.Map;

public interface CustomerService {

    List<Customer> getAll();
    int countCustomers();
    List<Customer> findByName(String name);
    //List<Customer> findByPolicyNumber(Integer policy);
    Customer findByPolicyNumber(Integer policy);
    Customer getCustomerById(Integer id);
    Customer addCustomer(CustomerDTO newCustomer);
    Customer addClaim(Integer policy, Map<String, String> data);
    Customer updatePolicyDetails(Integer customerId, Map<String, String> data);
}
