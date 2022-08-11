package com.allstate.speedyclaimsserver.service;

import com.allstate.speedyclaimsserver.data.ClaimRepository;
import com.allstate.speedyclaimsserver.data.CustomerRepository;
import com.allstate.speedyclaimsserver.domain.Claim;
import com.allstate.speedyclaimsserver.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BootstrapService {

    @Autowired
    ClaimRepository claimRepository;

    @Autowired
    CustomerRepository customerRepository;

    @PostConstruct
    public void initializeData() {

        if (customerRepository.findAll().size() == 0) {

            Customer customer1 = new Customer(null, 908444111, "Carol", "Murphy", "Los Angeles", "Box St", "Box Square",
                    "60114", null);
            Customer customer2 = new Customer(null, 901116546, "Mike", "Spectre", "Denver", "Beach Hill", "Beach Plazza",
                    "42224", null);
            Customer customer3 = new Customer(null, 902289218, "Angela", "Purle", "New York", "Dee Stree", "Bronx",
                    "83453", null);

            Claim claim1 = new Claim(null, "Auto", LocalDate.now(), 400d, "Paint Damage", "shunt to front", "Rejected", "Vauxhall", "Corsa",
                    "2017", null, null, customer1);
            Claim claim2 = new Claim(null, "Property", LocalDate.now(), 300d, "Roof damage", "Gutter damage", "Open", null, null,
                    null, null, null, customer2);
            Claim claim3 = new Claim(null, "Pet", LocalDate.now(), 200d, "operation", "usual", "Closed", null, null,
                    null, "dog", "Boxer", customer3);

            List<Claim> cl1 = new ArrayList<>();
            cl1.add(claim1);
            customer1.setClaims(cl1);


            List<Claim> cl2 = new ArrayList<>();
            cl2.add(claim2);
            customer2.setClaims(cl2);

            List<Claim> cl3 = new ArrayList<>();
            cl3.add(claim3);
            customer3.setClaims(cl3);

            customerRepository.save(customer1);
            customerRepository.save(customer2);
            customerRepository.save(customer3);

        }
    }

}
