package com.springboot.virtualexam.util.exception;

public class FatalErrorUnexpectedException extends RuntimeException{

    private static final String DESCRIPTION = "Fatal Error Unexpected (500)";

    public FatalErrorUnexpectedException(String message) {
        super(DESCRIPTION +". "+ message);
    }
}
