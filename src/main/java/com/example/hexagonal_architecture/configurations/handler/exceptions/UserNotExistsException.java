package com.example.hexagonal_architecture.configurations.handler.exceptions;

import com.example.hexagonal_architecture.configurations.handler.enums.EInternalTypeErrorCodes;

public class UserNotExistsException extends ErrorCodeException{

    public UserNotExistsException(){
        super(EInternalTypeErrorCodes.E400004);
    }

    public UserNotExistsException(String message){
        super(EInternalTypeErrorCodes.E400004, message);
    }
}
