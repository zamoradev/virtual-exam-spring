package com.springboot.virtualexam.util.exception;

public class ConflictException extends RuntimeException{

    private static final String DESCRIPTION = "Conflict Exception (409)";

    public ConflictException(String message) {
        super(DESCRIPTION +". "+ message);
    }
}
