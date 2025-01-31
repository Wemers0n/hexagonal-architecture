package com.example.hexagonal_architecture.configurations.handler.exceptions;

import com.example.hexagonal_architecture.configurations.handler.enums.EInternalTypeErrorCodes;

public class BadRequestException extends ErrorCodeException {


    public BadRequestException(){
        super(EInternalTypeErrorCodes.E400002);
    }

    public BadRequestException(String message){
        super(EInternalTypeErrorCodes.E400002, message);
    }
}
