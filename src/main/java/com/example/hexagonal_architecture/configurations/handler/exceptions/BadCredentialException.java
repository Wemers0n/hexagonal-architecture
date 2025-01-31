package com.example.hexagonal_architecture.configurations.handler.exceptions;

import com.example.hexagonal_architecture.configurations.handler.enums.EInternalTypeErrorCodes;

public class BadCredentialException extends ErrorCodeException {

    public BadCredentialException(){
        super(EInternalTypeErrorCodes.E400003);
    }

    public BadCredentialException(String message){
        super(EInternalTypeErrorCodes.E400003, message);
    }
}
