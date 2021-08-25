package com.springboot.virtualexam.subject.rest;

import com.springboot.virtualexam.subject.data.SubjectEntity;
import com.springboot.virtualexam.subject.service.ISubjectService;
import com.springboot.virtualexam.util.exception.BadRequestException;
import com.springboot.virtualexam.util.responseApi.ResponseApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/subject")
@RequiredArgsConstructor
public class SubjectResource {
    private final ISubjectService subjectService;

    @PreAuthorize("hasRole('ROLE_MANAGER')")
    @PostMapping
    public ResponseEntity<?> create(@RequestBody SubjectEntity subject){

        if(subjectService.existByName(subject.getName()))
            throw new BadRequestException("Lo sentimos no se guardo la materia porque ya existe.");

        subjectService.save(subject);

        return ResponseApi.builder()
                .status(HttpStatus.CREATED)
                .message("Se guardo la materia exitosamente.")
                .build().toResponseEntity();
    }
}
