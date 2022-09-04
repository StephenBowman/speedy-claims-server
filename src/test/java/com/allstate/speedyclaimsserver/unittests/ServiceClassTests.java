package com.allstate.speedyclaimsserver.unittests;

import com.allstate.speedyclaimsserver.data.ClaimRepository;
import com.allstate.speedyclaimsserver.data.CustomerRepository;
import com.allstate.speedyclaimsserver.domain.Customer;
import com.allstate.speedyclaimsserver.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class})
public class ServiceClassTests {

    List<Customer> customers = new ArrayList<>();

    @Autowired
    CustomerService customerService;

    @MockBean
    CustomerRepository customerRepository;

    @MockBean
    ClaimRepository claimRepository;

    @BeforeEach
    public void setUp(){
        customers.add(new Customer(1, 900000001, "Tom", "Jones", "Cardiff",
                "Fleet St", "The Mews", "12345", null));
        customers.add(new Customer(2, 900000002, "Jayne", "Doe", "Belfast",
                "Antrim Road", "Antrim", "23456", null));
        customers.add(new Customer(3, 900000003, "John", "Wayne", "Liverpool",
                "Canal Street", "Canal Lane", "34567", null));
        customers.add(new Customer(4, 900000004, "Mary", "Black", "Glasgow",
                "River Edge", "River Walk", "45678", null));
    }

    @Test
    public void testNumberOfCustomers(){

        Mockito.when(customerRepository.findAll()).thenReturn(customers);

        int result = customerService.countCustomers();
        assertEquals(4, result);

    }

    /*
    @Test
    public void testGetCustomerById(){

        Mockito.when(customerRepository.getCustomerById(1)).thenReturn(new Customer(1,
                900000001, "Tom", "Jones", "Cardiff",
                "Fleet St", "The Mews", "12345", null));

        Customer result = customerService.getCustomerById(1);
        assertEquals(1, result.getId());
    }*/


}
