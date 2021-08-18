package com.springboot.virtualexam.question.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IQuestionRepository extends JpaRepository<QuestionEntity, Long> {
}
