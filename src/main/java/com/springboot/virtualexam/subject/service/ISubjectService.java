package com.springboot.virtualexam.subject.service;

import com.springboot.virtualexam.subject.data.SubjectEntity;

public interface ISubjectService {
    boolean existByName(String name);
    void save(SubjectEntity subject);
}
