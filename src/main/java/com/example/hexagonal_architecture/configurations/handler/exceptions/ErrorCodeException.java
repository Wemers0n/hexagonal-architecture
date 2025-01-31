package com.example.hexagonal_architecture.configurations.handler.exceptions;

import com.example.hexagonal_architecture.configurations.handler.enums.EInternalTypeErrorCodes;

public class ErrorCodeException extends Exception{

    protected EInternalTypeErrorCodes errorCodes;

    protected ErrorCodeException(EInternalTypeErrorCodes errorCodes){
        super(errorCodes.getMessage());
        this.errorCodes = errorCodes;
    }

    protected ErrorCodeException(EInternalTypeErrorCodes errorCodes, Object... args){
        super(String.format(errorCodes.getMessage(), args));
        this.errorCodes = errorCodes;
    }

    public EInternalTypeErrorCodes getErrorCodes(){
        return errorCodes;
    }
}
