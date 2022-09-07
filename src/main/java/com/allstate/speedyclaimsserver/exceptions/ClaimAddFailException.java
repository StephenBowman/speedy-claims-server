package com.allstate.speedyclaimsserver.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ClaimAddFailException extends RuntimeException{

    public ClaimAddFailException(String message){
        super(message);
    }
}
