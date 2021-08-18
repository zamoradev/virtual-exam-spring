package com.springboot.virtualexam.exam.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IExamRepository extends JpaRepository<ExamEntity, Long> {
}
