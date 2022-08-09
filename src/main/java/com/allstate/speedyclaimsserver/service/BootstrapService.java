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

            Customer customer1 = new Customer(null, 908444322, "Paul", "Orange", "San Francisco", "Bay St", "Bay Square",
                    "60774", null);
            Customer customer2 = new Customer(null, 909876546, "Jane", "Blue", "Denver", "Black Hill", "Silver Bay",
                    "40384", null);
            Customer customer3 = new Customer(null, 907689098, "Sharon", "Green", "New York", "Any Street", "Any City",
                    "80633", null);

            Claim claim1 = new Claim(null, "Auto", LocalDate.now(), 450d, "Paint Damage", "shunt to rear", "Open", "Opel", "Astra",
                    "2018", null, null, customer1);
            Claim claim2 = new Claim(null, "Property", LocalDate.now(), 250d, "Storm damage", "burst pipe", "Open", null, null,
                    null, null, null, customer2);
            Claim claim3 = new Claim(null, "Pet", LocalDate.now(), 300d, "Vaccinations", "usual", "Closed", null, null,
                    null, "dog", "Collie", customer3);

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
