package com.allstate.speedyclaimsserver.service;

import com.allstate.speedyclaimsserver.data.CustomerRepository;
import com.allstate.speedyclaimsserver.domain.Claim;
import com.allstate.speedyclaimsserver.domain.Customer;
import com.allstate.speedyclaimsserver.dtos.CustomerDTO;
import com.allstate.speedyclaimsserver.exceptions.CustomerNotFoundException;
import com.allstate.speedyclaimsserver.exceptions.InvalidNewCustomerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.time.LocalDate;
import java.util.*;

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
        logger.info("URL Name "+ name);
        if(!customer.isEmpty()){
            return customer;
        }
        logger.info("There is no customer with name "+ name);
        throw new CustomerNotFoundException("There is no customer with name "+ name);
        //return customerRepository.findByName(name);
    }

//    @Override
//    public List<Customer> findByPolicyNumber(Integer policy) {
//        List<Customer> customer = customerRepository.findByPolicyNumber(policy);
//        if(!customer.isEmpty()){
//            return customer;
//        }
//        logger.info("There is no customer with policy "+ policy);
//        throw new CustomerNotFoundException("There is no customer with policy "+ policy);
//
//        //return customerRepository.findByPolicyNumber(policy);
//    }

    @Override
    public Customer findByPolicyNumber(Integer policy) {
        Customer customer = customerRepository.findByPolicyNumber(policy);
        if(customer != null){
            return customer;
        }
        logger.info("There is no customer with policy "+ policy);
        throw new CustomerNotFoundException("There is no customer with policy "+ policy);
    }

    @Override
    public Customer getCustomerById(Integer id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            return optionalCustomer.get();
        }
        logger.info("There is no customer with id: "+ id);
        throw new CustomerNotFoundException("There is no customer with id: "+ id);
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

    @Override
    public Customer addClaim(Integer policy, Map<String, String> data) {
        Customer customer = findByPolicyNumber(policy);
        Claim clm = new Claim();
        Customer c1 = customer;

        if(c1 != null && data.containsKey("claimType")){
            if(data.get("claimType").equalsIgnoreCase("Auto") ||
                    data.get("claimType").equalsIgnoreCase("Property") ||
                    data.get("claimType").equalsIgnoreCase("Pet")){
                clm = new Claim(null, data.get("claimType"), LocalDate.now(),
                        Double.parseDouble(data.get("estimatedAmt")), data.get("claimReason"), data.get("claimDescription"),
                        data.get("claimStatus"), data.get("vehicleMake"), data.get("vehicleModel"),
                        data.get("vehicleYear"), data.get("animalType"), data.get("animalBreed"), c1);
            }else{
                // throw exception
            }

            List<Claim> claimList = null;
            if(c1.getClaims().isEmpty()){
                claimList = new ArrayList<Claim>();
            }else{
                claimList = c1.getClaims();
            }
            claimList.add(clm);
            c1.setClaims(claimList);
        }
        return customerRepository.save(c1);
    }

    @Override
    public Customer updatePolicyDetails(Integer customerId, Map<String, String> data) {

        Customer customerUpdate = getCustomerById(customerId);

        if(data.containsKey("firstName")){
            if(data.get("firstName") != null){
                customerUpdate.setFirstName(data.get("firstName"));
            }
        }

        if(data.containsKey("name")){
            if(data.get("name") != null){
                customerUpdate.setName(data.get("name"));
            }
        }

        if(data.containsKey("addressStreet1")){
            if(data.get("addressStreet1") != null){
                customerUpdate.setAddressStreet1(data.get("addressStreet1"));
            }
        }

        if(data.containsKey("addressStreet2")){
            if(data.get("addressStreet2") != null){
                customerUpdate.setAddressStreet2(data.get("addressStreet2"));
            }
        }

        if(data.containsKey("addressCity")){
            if(data.get("addressCity") != null){
                customerUpdate.setAddressCity(data.get("addressCity"));
            }
        }

        if(data.containsKey("addressPostCode")){
            if(data.get("addressPostCode") != null){
                customerUpdate.setAddressPostCode(data.get("addressPostCode"));
            }
        }

        return customerRepository.save(customerUpdate);
    }

}
