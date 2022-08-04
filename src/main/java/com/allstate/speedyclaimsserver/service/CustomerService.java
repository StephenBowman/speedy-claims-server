package com.allstate.speedyclaimsserver.service;

import com.allstate.speedyclaimsserver.domain.Customers;

import java.util.List;

public interface CustomerService {

    List<Customers> getAll();
    List<Customers> getOpenClaims();
}
