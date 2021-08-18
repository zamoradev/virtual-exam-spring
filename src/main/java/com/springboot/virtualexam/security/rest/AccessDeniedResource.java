package com.springboot.virtualexam.security.rest;

import com.springboot.virtualexam.util.exception.ForbiddenException;
import com.springboot.virtualexam.util.exception.UnauthorizedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class AccessDeniedResource {

    @GetMapping("/access-denied")
    public ResponseEntity<?> forbidden(){
        throw new ForbiddenException("Acceso denegado a la acción solicitada.");
    }

    @GetMapping("/no-credentials")
    public ResponseEntity<?> unauthorized(){
        throw new UnauthorizedException("carece de credenciales válidas de autenticación para el recurso solicitado.");
    }
}
