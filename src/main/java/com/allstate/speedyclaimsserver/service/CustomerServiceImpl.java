package com.allstate.speedyclaimsserver.service;

import com.allstate.speedyclaimsserver.data.CustomerRepository;
import com.allstate.speedyclaimsserver.domain.Customer;
import com.allstate.speedyclaimsserver.dtos.CustomerDTO;
import com.allstate.speedyclaimsserver.exceptions.CustomerNotFoundException;
import com.allstate.speedyclaimsserver.exceptions.InvalidNewCustomerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    Logger logger = LoggerFactory.getLogger(CustomerService.class);

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public int countCustomers() {
        return customerRepository.findAll().size();
    }

    @Override
    public List<Customer> findByName(String name) {
        List<Customer> customer = customerRepository.findByName(name);

        if(!customer.isEmpty()){
            return customer;
        }
        logger.info("There is no customer with name "+ name);
        throw new CustomerNotFoundException("There is no customer with name "+ name);
        //return customerRepository.findByName(name);
    }

    @Override
    public List<Customer> findByPolicyNumber(Integer policy) {
        List<Customer> customer = customerRepository.findByPolicyNumber(policy);

        if(!customer.isEmpty()){
            return customer;
        }
        logger.info("There is no customer with policy "+ policy);
        throw new CustomerNotFoundException("There is no customer with policy "+ policy);

        //return customerRepository.findByPolicyNumber(policy);
    }

    @Override
    public Customer addCustomer(CustomerDTO newCustomerDTO) {
        Customer customer = newCustomerDTO.toCustomer();

        if(customer.getPolicyNumber() <= 0 || customer.getName() == null){
            logger.info("Policy number and name required");
            throw new InvalidNewCustomerException("Policy number and name required");
        }

        try{
            return customerRepository.save(customer);
        }
        catch (Exception e){
            logger.info("We are unable to save the new customer");
            throw new InvalidNewCustomerException("We are unable to save the new customer");
        }
    }

}
