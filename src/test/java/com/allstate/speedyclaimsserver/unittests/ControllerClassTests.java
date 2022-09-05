package com.allstate.speedyclaimsserver.unittests;

import com.allstate.speedyclaimsserver.control.ClaimController;
import com.allstate.speedyclaimsserver.control.CustomersController;
import com.allstate.speedyclaimsserver.data.ClaimRepository;
import com.allstate.speedyclaimsserver.data.CustomerRepository;
import com.allstate.speedyclaimsserver.domain.Claim;
import com.allstate.speedyclaimsserver.domain.Customer;
import com.allstate.speedyclaimsserver.service.ClaimService;
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

import java.time.LocalDate;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class})
public class ControllerClassTests {

    @Autowired
    CustomersController customersController;

    @Autowired
    ClaimController claimController;

    @MockBean
    CustomerService customerService;

    @MockBean
    ClaimService claimService;

    @MockBean
    CustomerRepository customerRepository;

    @MockBean
    ClaimRepository claimRepository;

    @BeforeEach
    public void runFirst(){
        Mockito.when(customerService.countCustomers())
                .thenReturn(101);

        Mockito.when(customerService.getCustomerById(1))
                .thenReturn(new Customer(1, 900000001, "Tom", "Jones", "Cardiff",
                        "Fleet St", "The Mews", "12345", null));

        Mockito.when(customerService.findByPolicyNumber(900000001))
                .thenReturn(new Customer(1, 900000001, "Tom", "Jones", "Cardiff",
                        "Fleet St", "The Mews", "12345", null));
    }


    @Test
    public void checkCustomerVolumeIsMapAndKey(){

        Map<String,String> result = customersController.getNumberOfCustomers();
        assertEquals("101", result.get("volume"));
    }

    @Test
    public void checkGetCustomerById(){

        Customer result = customersController.getById(1);
        assertEquals(1, result.getId());
    }

    @Test
    public void checkGetCustomerByPolicy(){
        Customer result = customersController.findByPolicyNumber(900000001);
        assertEquals(900000001, result.getPolicyNumber());
    }

    @Test
    public void checkGetClaimById(){

        Mockito.when(claimService.findByClaimId(1))
                .thenReturn(new Claim(1, "Auto", LocalDate.parse("2020-01-08"), 200d,
                        "Broken Windscreen", "Minor Accident", "Open", "Ford",
                        "Fiesta", "2015", null, null, null));

        Claim result = claimController.getById(1);
        assertEquals(1, result.getId());
    }
}
