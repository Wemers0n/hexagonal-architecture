package com.example.hexagonal_architecture.configurations.handler.exceptions;

import com.example.hexagonal_architecture.configurations.handler.enums.EInternalTypeErrorCodes;

public class InvalidDateException extends ErrorCodeException{

    public InvalidDateException() {
        super(EInternalTypeErrorCodes.E400005);
    }

    public InvalidDateException(String message) {
        super(EInternalTypeErrorCodes.E400005, message);
    }

}
