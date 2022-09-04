package com.allstate.speedyclaimsserver.data;

import com.allstate.speedyclaimsserver.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    public List<Customer> findByName(String name);
    //public List<Customer> findByPolicyNumber(Integer policy);
    public Customer findByPolicyNumber(Integer policy);
    public Customer getCustomerById(Integer id);

}
