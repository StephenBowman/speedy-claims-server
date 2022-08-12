package com.allstate.speedyclaimsserver.service;

import com.allstate.speedyclaimsserver.data.ClaimRepository;
import com.allstate.speedyclaimsserver.domain.Claim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public List<Claim> findByCustomerId(Integer customerId) {
        return (List<Claim>) claimRepository.findByCustomerId(customerId);
    }

    @Override
    public Claim findByClaimId(Integer id) {
        Optional<Claim> optionalClaim = claimRepository.findById(id);

        if(optionalClaim.isPresent()){
            return optionalClaim.get();
        }
        return null;
    }


}
