package com.example.hexagonal_architecture.configurations.handler.exceptions;

import com.example.hexagonal_architecture.configurations.handler.enums.EInternalTypeErrorCodes;

public class EmailAlreadyRegisteredException extends ErrorCodeException {

    public EmailAlreadyRegisteredException(){
        super(EInternalTypeErrorCodes.E400001);
    }

    public EmailAlreadyRegisteredException(String message) {
        super(EInternalTypeErrorCodes.E400001, message);
    }

}
