package com.springboot.virtualexam.subject.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ISubjectRepository extends JpaRepository<SubjectEntity, Long> {
    boolean existsSubjectByName(String name);
}
