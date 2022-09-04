package com.allstate.speedyclaimsserver.unittests;

import com.allstate.speedyclaimsserver.domain.Customer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DomainClassTests {

    @Test
    public void testCustomerEquality(){
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();

        customer1.setId(2);
        customer2.setId(2);

        assertEquals(customer1.getId(), customer2.getId());

    }

    @Test
    public void testCustomerNotEqual(){
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();

        customer1.setId(1);
        customer2.setId(2);

        assertNotEquals(customer1.getId(), customer2.getId());

    }


}
