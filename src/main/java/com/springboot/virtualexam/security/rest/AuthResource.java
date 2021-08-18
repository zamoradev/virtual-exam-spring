package com.springboot.virtualexam.security.rest;

import com.springboot.virtualexam.security.data.SignIn;
import com.springboot.virtualexam.security.data.TokenJwt;
import com.springboot.virtualexam.security.jwt.JwtProvider;
import com.springboot.virtualexam.util.responseApi.ResponseFileError;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthResource {
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    @PostMapping("/signIn")
    public ResponseEntity<?> login(@Valid @RequestBody SignIn signIn, BindingResult result){
        if(result.hasErrors())
            return ResponseFileError.get(result.getFieldErrors());

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signIn.getUsername(), signIn.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateToken(authentication);
        TokenJwt jwtCustom = new TokenJwt(jwt);

        return ResponseEntity.status(HttpStatus.OK).body(jwtCustom);
    }
}
