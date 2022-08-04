package com.allstate.speedyclaimsserver.service;

import com.allstate.speedyclaimsserver.domain.Customers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Override
    public List<Customers> getAll() {
        return null;
    }

    @Override
    public List<Customers> getOpenClaims() {
        return null;
    }
}
