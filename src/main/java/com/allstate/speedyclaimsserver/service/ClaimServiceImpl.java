package com.allstate.speedyclaimsserver.service;

import com.allstate.speedyclaimsserver.data.ClaimRepository;
import com.allstate.speedyclaimsserver.domain.Claim;
import com.allstate.speedyclaimsserver.domain.Customer;
import com.allstate.speedyclaimsserver.dtos.ClaimDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaimServiceImpl implements ClaimService{

    @Autowired
    private ClaimRepository claimRepository;

    @Override
    public List<Claim> getAll() {

        return claimRepository.findAll();
    }

    @Override
    public List<Claim> findByClaimStatus(String status) {

        return claimRepository.findByClaimStatus(status);
    }

    @Override
    public List<Claim> findByPolicyNumber(Integer policy) {
        return (List<Claim>) claimRepository.findByPolicyNumber(policy);
    }

    @Override
    public Claim addClaim(ClaimDTO newClaim, Customer customer) {
        return claimRepository.save(newClaim.toClaim());
    }

}
