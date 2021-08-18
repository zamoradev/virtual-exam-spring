package com.springboot.virtualexam.util.exception;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {
    private final ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("America/El_Salvador"));

    @ExceptionHandler({
            BadRequestException.class,
            DuplicateKeyException.class,
            HttpRequestMethodNotSupportedException.class,
            MethodArgumentNotValidException.class,
            MissingRequestHeaderException.class,
            MissingServletRequestParameterException.class,
            MethodArgumentTypeMismatchException.class,
            HttpMessageNotReadableException.class
    })
    public ResponseEntity<?>  handleBadRequest(BadRequestException e){
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        ApiException apiException = ApiException.builder()
                .status(badRequest)
                .message(e.getMessage())
                .timestamp(zonedDateTime)
                .build();

        return ResponseEntity.status(badRequest).body(apiException);
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<?> handleNotFound(NotFoundException e){
        HttpStatus notFound = HttpStatus.NOT_FOUND;

        ApiException apiException = ApiException.builder()
                .status(notFound)
                .message(e.getMessage())
                .timestamp(zonedDateTime)
                .build();

        return ResponseEntity.status(notFound).body(apiException);
    }

    @ExceptionHandler({ConflictException.class})
    public ResponseEntity<?> handleConflict(ConflictException e){
        HttpStatus conflict = HttpStatus.CONFLICT;

        ApiException apiException = ApiException.builder()
                .status(conflict)
                .message(e.getMessage())
                .timestamp(zonedDateTime)
                .build();

        return ResponseEntity.status(conflict).body(apiException);
    }

    @ExceptionHandler({ForbiddenException.class})
    public ResponseEntity<?> handleForbidden(ForbiddenException e){
        HttpStatus forbidden = HttpStatus.FORBIDDEN;

        ApiException apiException = ApiException.builder()
                .status(forbidden)
                .message(e.getMessage())
                .timestamp(zonedDateTime)
                .build();

        return ResponseEntity.status(forbidden).body(apiException);
    }

    @ExceptionHandler({UnauthorizedException.class})
    public ResponseEntity<?> handleUnauthorized(UnauthorizedException e){
        HttpStatus unauthorized = HttpStatus.UNAUTHORIZED;

        ApiException apiException = ApiException.builder()
                .status(unauthorized)
                .message(e.getMessage())
                .timestamp(zonedDateTime)
                .build();

        return ResponseEntity.status(unauthorized).body(apiException);
    }

    @ExceptionHandler({FatalErrorUnexpectedException.class})
    public ResponseEntity<?> handleFatalErrorUnexpected(FatalErrorUnexpectedException e){
        HttpStatus internalServerError = HttpStatus.INTERNAL_SERVER_ERROR;

        ApiException apiException = ApiException.builder()
                .status(internalServerError)
                .message(e.getMessage())
                .timestamp(zonedDateTime)
                .build();

        return ResponseEntity.status(internalServerError).body(apiException);
    }

}
