package com.springboot.virtualexam.course.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseRepository extends JpaRepository<CourseEntity, Long> {
}
