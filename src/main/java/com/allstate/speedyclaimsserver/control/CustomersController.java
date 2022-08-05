package com.allstate.speedyclaimsserver.control;

import com.allstate.speedyclaimsserver.domain.Customer;
import com.allstate.speedyclaimsserver.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/customer")
public class CustomersController {

    @Autowired
    private CustomerService customerService;

    @GetMapping()
    public List<Customer> getAll(){
        return customerService.getAll();
    }
}
