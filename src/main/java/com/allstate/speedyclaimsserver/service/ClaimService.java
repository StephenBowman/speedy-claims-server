package com.allstate.speedyclaimsserver.service;

import com.allstate.speedyclaimsserver.domain.Claim;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ClaimService {

    List<Claim> getAll();
    List<Claim> findByClaimStatus(String status);
    List<Claim> findByCustomerId(Integer policy);
    Claim findByClaimId(Integer claimId);
    Claim updateClaim(Integer claimId, Map<String, String> data);
}
