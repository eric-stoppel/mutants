package com.ericstoppel.mutants.exceptions;

public class InvalidNitrogenBaseException extends RuntimeException{
    private String message;

    public InvalidNitrogenBaseException(String msg){
        super(msg);
    }
}
