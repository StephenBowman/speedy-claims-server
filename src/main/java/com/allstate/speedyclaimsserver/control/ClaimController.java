package com.allstate.speedyclaimsserver.control;

import com.allstate.speedyclaimsserver.domain.Claim;
import com.allstate.speedyclaimsserver.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

}
