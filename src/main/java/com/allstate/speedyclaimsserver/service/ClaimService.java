package com.allstate.speedyclaimsserver.service;

import com.allstate.speedyclaimsserver.domain.Claim;

import java.util.List;

public interface ClaimService {

    List<Claim> getAll();
}
