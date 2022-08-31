package com.allstate.speedyclaimsserver.control;

import com.allstate.speedyclaimsserver.domain.Claim;
import com.allstate.speedyclaimsserver.domain.Customer;
import com.allstate.speedyclaimsserver.dtos.CustomerDTO;
import com.allstate.speedyclaimsserver.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    Logger logger = LoggerFactory.getLogger(CustomerService.class);
    @Autowired
    CustomerService customerService;

    @GetMapping()
    public List<Customer> getAll(@RequestParam(value="name", required=false) String name,
                                 @RequestParam(value="policy", required=false) Integer policy){

        if(name != null){
            return customerService.findByName(name);
        } //else if(policy != null){
//            return customerService.findByPolicyNumber(policy);
//        }
        return customerService.getAll();
    }

    @GetMapping("/volume")
    public Map<String, String> getNumberOfCustomers(){
        Integer volume = customerService.countCustomers();
        Map<String, String> results = new HashMap<>();
        results.put("volume", volume.toString());
        return results;
    }

    @GetMapping(value ="/policy/{policy}", produces={MediaType.APPLICATION_JSON_VALUE})
    public Customer findByPolicyNumber(@PathVariable("policy") Integer policy) {
        return customerService.findByPolicyNumber(policy);
    }

    @GetMapping(value ="/name/{name}", produces={MediaType.APPLICATION_JSON_VALUE})
    public List<Customer> findByName(@PathVariable("name") String name) {
        return customerService.findByName(name);
    }

    @GetMapping(value ="/{id}", produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public Customer getById(@PathVariable("id") Integer id) {
        return customerService.getCustomerById(id);
    }

    @PutMapping("/{id}")
    public Customer addClaim(@PathVariable("id") Integer id,
                             @RequestBody Map<String, String> data){
        return customerService.addClaim(id, data);
    }

    @PutMapping("/update/{id}")
    public Customer updatePolicyDetails(@PathVariable("id") Integer customerId,
                             @RequestBody Map<String, String> data){
        return customerService.updatePolicyDetails(customerId, data);
    }

    @PostMapping
    public Customer newCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.addCustomer(customerDTO);
    }

}
