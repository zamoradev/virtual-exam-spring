package com.springboot.virtualexam.degree.rest;

import com.springboot.virtualexam.degree.data.DegreeEntity;
import com.springboot.virtualexam.degree.service.IDegreeService;
import com.springboot.virtualexam.subject.data.SubjectEntity;
import com.springboot.virtualexam.util.exception.BadRequestException;
import com.springboot.virtualexam.util.responseApi.ResponseApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/degree")
@RequiredArgsConstructor
public class DegreeResource {
    private final IDegreeService degreeService;

    @PreAuthorize("hasRole('ROLE_MANAGER')")
    @PostMapping
    public ResponseEntity<?> create(@RequestBody DegreeEntity degree){

        if(degreeService.existByName(degree.getName()))
            throw new BadRequestException("Lo sentimos no se guardo el grado porque ya existe.");

        degreeService.save(degree);

        return ResponseApi.builder()
                .status(HttpStatus.CREATED)
                .message("Se guardo el grado exitosamente.")
                .build().toResponseEntity();
    }

}
