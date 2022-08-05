package com.allstate.speedyclaimsserver.data;

import com.allstate.speedyclaimsserver.domain.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Integer> {


}
