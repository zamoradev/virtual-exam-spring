package com.springboot.virtualexam.course.service;

import com.springboot.virtualexam.course.data.CourseEntity;
import com.springboot.virtualexam.course.data.ICourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements ICourseService{
    private final ICourseRepository courseRepository;

    @Override
    public boolean fieldsDoExist(CourseEntity course) {
        return courseRepository.existsCourseByTeacherIdAndSectionIdAndDegreeIdAndSubjectId(
                course.getTeacher().getId(),
                course.getSection().getId(),
                course.getDegree().getId(),
                course.getSubject().getId()
        );
    }

    @Override
    public void save(CourseEntity course) {
        courseRepository.save(course);
    }
}
