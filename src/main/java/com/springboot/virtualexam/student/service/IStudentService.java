package com.springboot.virtualexam.student.service;

import com.springboot.virtualexam.student.data.StudentEntity;

public interface IStudentService {
    boolean existsFieldRepeat(StudentEntity student);
    String save(StudentEntity student);
}
