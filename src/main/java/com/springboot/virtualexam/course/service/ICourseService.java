package com.springboot.virtualexam.course.service;

import com.springboot.virtualexam.course.data.CourseEntity;

public interface ICourseService {
    boolean fieldsDoExist(CourseEntity course);
    void save(CourseEntity course);
}
