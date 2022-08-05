package com.allstate.speedyclaimsserver.control;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClaimController {

    @GetMapping("/api/health")
    public String healthcheck(){
        return "ok";
    }
}
