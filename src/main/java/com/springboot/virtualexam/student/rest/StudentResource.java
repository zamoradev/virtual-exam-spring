package com.springboot.virtualexam.student.rest;

import com.springboot.virtualexam.rol.data.RolName;
import com.springboot.virtualexam.student.data.StudentEntity;
import com.springboot.virtualexam.student.service.IStudentService;
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
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentResource {
    private final IStudentService studentService;
    private final IUserService userService;

    @PreAuthorize("hasRole('ROLE_TEACHER')")
    @PostMapping
    public ResponseEntity<?> create(@RequestBody StudentEntity student, BindingResult result){
        /*if(result.hasErrors())
            return ResponseFileError.get(result.getFieldErrors());*/

        if(studentService.existsFieldRepeat(student))
            throw new BadRequestException("error campos repetido.");

        String username = studentService.save(student);
        String rol = RolName.STUDENT.toString();

        userService.save(username, rol);

        return ResponseApi.builder()
                .message("El estudiante se ha registrado exitosamente.")
                .status(HttpStatus.CREATED)
                .build().toResponseEntity();
    }

}
