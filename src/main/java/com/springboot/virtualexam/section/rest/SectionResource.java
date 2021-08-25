package com.springboot.virtualexam.section.rest;

import com.springboot.virtualexam.section.data.SectionEntity;
import com.springboot.virtualexam.section.service.ISectionService;
import com.springboot.virtualexam.util.exception.BadRequestException;
import com.springboot.virtualexam.util.responseApi.ResponseApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/section")
@RequiredArgsConstructor
public class SectionResource {
    private final ISectionService sectionService;

    @PreAuthorize("hasRole('ROLE_MANAGER')")
    @PostMapping
    public ResponseEntity<?> create(@RequestBody SectionEntity section){
        section.nameToUpperCase();

        if(sectionService.existByName(section.getName()))
            throw new BadRequestException("Lo sentimos no se guardo la sección porque ya existe.");

        sectionService.save(section);

        return ResponseApi.builder()
                .status(HttpStatus.CREATED)
                .message("Se guardo la sección exitosamente.")
                .build().toResponseEntity();
    }
}
