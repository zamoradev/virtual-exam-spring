package com.springboot.virtualexam.util.exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Getter
@Builder
public class ApiException {
    private final String message;
    private final HttpStatus status;
    private final ZonedDateTime timestamp;
}
