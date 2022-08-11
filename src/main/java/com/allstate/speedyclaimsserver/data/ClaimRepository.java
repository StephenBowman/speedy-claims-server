package com.allstate.speedyclaimsserver.data;

import com.allstate.speedyclaimsserver.domain.Claim;
import com.allstate.speedyclaimsserver.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Integer>{

    List<Claim> findByClaimStatus(String status);
    List<Claim> findByCustomerId(Integer customerId);
}
