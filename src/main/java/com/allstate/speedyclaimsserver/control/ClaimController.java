package com.allstate.speedyclaimsserver.control;

import com.allstate.speedyclaimsserver.domain.Claim;
import com.allstate.speedyclaimsserver.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/claim")
public class ClaimController {

    @Autowired
    ClaimService claimService;

    @GetMapping()
    public List<Claim> getAll(@RequestParam(value="status", required=false) String status){
        if(status != null){
            return claimService.findByClaimStatus(status);
        }
        return claimService.getAll();
    }

    @GetMapping(value="/{id}", produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public Claim getById(@PathVariable("id") Integer id){
        return claimService.findByClaimId(id);
    }

    @PutMapping("/update/{id}")
    public Claim updateClaim(@PathVariable("id") Integer claimId,
                             @RequestBody Map<String, String> data){
        return claimService.updateClaim(claimId, data);
    }

}
