package com.allstate.speedyclaimsserver.service;

import com.allstate.speedyclaimsserver.domain.Claim;
import com.allstate.speedyclaimsserver.domain.Customer;
import com.allstate.speedyclaimsserver.dtos.ClaimDTO;
import com.allstate.speedyclaimsserver.dtos.CustomerDTO;

import java.util.List;

public interface ClaimService {

    List<Claim> getAll();
    List<Claim> findByClaimStatus(String status);
    Claim addClaim(ClaimDTO newClaim);
}
