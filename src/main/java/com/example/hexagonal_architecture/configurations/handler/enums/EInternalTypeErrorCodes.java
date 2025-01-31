package com.example.hexagonal_architecture.configurations.handler.enums;

public enum EInternalTypeErrorCodes {

    E500000("Internal error without mapped cause."),
    E400001("An user with this e-mail already exists: %s"),
    E400002("Bad Request to: %s"),
    E400003("Invalid credentials."),
    E400004("This user not exists: %s");

    private final String message;

    EInternalTypeErrorCodes(String message){
        this.message = message;
    }

    public String getValue(){
        return this.name();
    }

    public String getMessage(){
        return message;
    }

    @Override
    public String toString(){
        return String.format("Fault code: %s = %s", getMessage());
    }
}
