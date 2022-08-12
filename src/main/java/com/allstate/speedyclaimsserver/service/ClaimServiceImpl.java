package com.allstate.speedyclaimsserver.service;

import com.allstate.speedyclaimsserver.data.ClaimRepository;
import com.allstate.speedyclaimsserver.domain.Claim;
import com.allstate.speedyclaimsserver.exceptions.ClaimNotFoundException;
import com.allstate.speedyclaimsserver.exceptions.InvalidNewCustomerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClaimServiceImpl implements ClaimService{

    Logger logger = LoggerFactory.getLogger(CustomerService.class);

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
        throw new ClaimNotFoundException("Claim not found for claim id " + id);
    }

    @Override
    public Claim updateClaim(Integer claimId, Map<String, String> data) {

        ArrayList<String> validValues = new ArrayList<>(Arrays.asList("open", "in progress", "closed", "rejected"));

        Claim clmUpdate = findByClaimId(claimId);

        if(data.containsKey("claimStatus") && data.get("claimStatus") != null
            && validValues.contains(data.get("claimStatus").toLowerCase())) {
                clmUpdate.setClaimStatus(data.get("claimStatus"));
        }else if(data.containsKey("claimStatus") && data.get("claimStatus") != null){
            throw new ClaimNotFoundException("Claim status invalid: ("
                    + data.get("claimStatus")
                    + ") valid values are: "
                    + validValues.toString());
        }

        if(data.containsKey("estimatedAmt")){
            try{
                clmUpdate.setEstimatedAmt(Double.parseDouble(data.get("estimatedAmt")));
            }catch(NumberFormatException e){
                throw new NumberFormatException("Invalid input for estimated amount, please enter numeric values");
            }
        }

        return claimRepository.save(clmUpdate);
    }

}
