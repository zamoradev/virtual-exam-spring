package com.springboot.virtualexam.util.responseApi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseApi {
    private String message;
    private HttpStatus status;
    private Object data;

    public ResponseEntity<?> toResponseEntity(){
        Map<String, Object> response = new HashMap<>();
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("America/El_Salvador"));

        if(message != null) response.put("message", message);

        if(data != null) response.put("data", data);

        response.put("status", status);
        response.put("timestamp", zonedDateTime);
        return ResponseEntity.status(status).body(response);
    }

}
