package com.ericstoppel.mutants.exceptions;

public class InvalidDnaSequenceException extends RuntimeException {
    private String message;

    public InvalidDnaSequenceException(String msg){
        super(msg);
    }
}
