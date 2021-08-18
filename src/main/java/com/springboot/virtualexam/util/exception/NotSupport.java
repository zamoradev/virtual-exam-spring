package com.springboot.virtualexam.util.exception;

public class NotSupport extends RuntimeException{
    private static final String DESCRIPTION = "Not Support (405)";

    public NotSupport(String message) {
        super(DESCRIPTION +". "+ message);
    }
}
