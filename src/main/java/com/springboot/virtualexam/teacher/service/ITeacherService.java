package com.springboot.virtualexam.teacher.service;

import com.springboot.virtualexam.teacher.data.TeacherEntity;

public interface ITeacherService {
    boolean existsFieldRepeat(TeacherEntity teacher);
    String save(TeacherEntity teacher);
}
