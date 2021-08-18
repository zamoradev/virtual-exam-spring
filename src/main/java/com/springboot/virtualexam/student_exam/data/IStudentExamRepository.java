package com.springboot.virtualexam.student_exam.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentExamRepository extends JpaRepository<StudentExamEntity, Long> {
}
