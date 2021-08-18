package com.springboot.virtualexam.util.responseApi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResponseFileError {
    public static ResponseEntity<?> get(List<FieldError> fieldsError) {
        Map<String, Object> response = new HashMap<>();
        List<String> error = fieldsError.stream()
                .map(err -> "El campo: " + err.getField() + " " + err.getDefaultMessage()).collect(Collectors.toList());

        response.put("message", error);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
