package com.allstate.speedyclaimsserver.service;

import com.allstate.speedyclaimsserver.data.CustomerRepository;
import com.allstate.speedyclaimsserver.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAll() {

        return customerRepository.findAll();
    }

}
