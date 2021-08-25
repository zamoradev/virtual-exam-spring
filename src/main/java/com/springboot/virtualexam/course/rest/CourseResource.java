package com.springboot.virtualexam.course.rest;

import com.springboot.virtualexam.course.data.CourseEntity;
import com.springboot.virtualexam.course.service.ICourseService;
import com.springboot.virtualexam.util.exception.BadRequestException;
import com.springboot.virtualexam.util.exception.NotFoundException;
import com.springboot.virtualexam.util.responseApi.ResponseApi;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseResource {
    private final ICourseService courseService;

    @PreAuthorize("hasRole('ROLE_MANAGER')")
    @PostMapping
    public ResponseEntity<?> create(@RequestBody CourseEntity course){

        if(courseService.fieldsDoExist(course))
            throw new BadRequestException("Un docente ya esta asignado a una materia, grado y sección");
        
        try{
            courseService.save(course);
        }catch(DataAccessException e){
            throw new NotFoundException("Un campo no es correcto verifique lo datos enviados");
        }

        return ResponseApi.builder()
                .message("Esto es una prueba")
                .status(HttpStatus.OK)
                .build().toResponseEntity();
    }
}
