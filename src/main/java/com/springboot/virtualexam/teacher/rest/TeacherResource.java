package com.springboot.virtualexam.teacher.rest;

import com.springboot.virtualexam.rol.data.RolName;
import com.springboot.virtualexam.teacher.data.TeacherEntity;
import com.springboot.virtualexam.teacher.service.ITeacherService;
import com.springboot.virtualexam.user.service.IUserService;
import com.springboot.virtualexam.util.exception.BadRequestException;
import com.springboot.virtualexam.util.responseApi.ResponseApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherResource {
    private final ITeacherService teacherService;
    private final IUserService userService;

    @PreAuthorize("hasRole('ROLE_MANAGER')")
    @PostMapping
    public ResponseEntity<?> create(@RequestBody TeacherEntity teacher, BindingResult result){
        /*if(result.hasErrors())
            return ResponseFileError.get(result.getFieldErrors());*/

        if(teacherService.existsFieldRepeat(teacher))
            throw new BadRequestException("error campos repetido.");

        String username = teacherService.save(teacher);
        String rol = RolName.TEACHER.toString();

        userService.save(username, rol);

        return ResponseApi.builder()
                .message("El docente se ha registrado exitosamente.")
                .status(HttpStatus.CREATED)
                .build().toResponseEntity();
    }

}
