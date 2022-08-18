package com.allstate.speedyclaimsserver.control;

import com.allstate.speedyclaimsserver.domain.Customer;
import com.allstate.speedyclaimsserver.dtos.CustomerDTO;
import com.allstate.speedyclaimsserver.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/customer")
public class CustomersController {

    @Autowired
    CustomerService customerService;

    @GetMapping()
    public List<Customer> getAll(@RequestParam(value="name", required=false) String name,
                                 @RequestParam(value="policy", required=false) Integer policy,
                                 @RequestParam(value="id", required=false) Integer id){

        if(name != null){
            return customerService.findByName(name);
        } else if(policy != null){
            return customerService.findByPolicyNumber(policy);
        }
        return customerService.getAll();
    }

    @GetMapping("/volume")
    public Map<String, String> getNumberOfCustomers(){
        Integer volume = customerService.countCustomers();
        Map<String, String> results = new HashMap<>();
        results.put("volume", volume.toString());
        return results;
    }

    @PostMapping
    public Customer newCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.addCustomer(customerDTO);
    }

    @GetMapping(value ="/{id}", produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public Customer getById(@PathVariable("id") Integer id) {
        return customerService.getCustomerById(id);
    }

    @PutMapping("/{policyNumber}")
    public Customer addClaim(@PathVariable("policyNumber") Integer policyNumber,
                             @RequestBody Map<String, String> data){
        return customerService.addClaim(policyNumber, data);
    }


}
