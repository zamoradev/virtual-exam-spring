package com.springboot.virtualexam.subject.service;

import com.springboot.virtualexam.subject.data.ISubjectRepository;
import com.springboot.virtualexam.subject.data.SubjectEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements ISubjectService{
    private final ISubjectRepository subjectRepository;

    @Override
    public boolean existByName(String name) {
        return subjectRepository.existsSubjectByName(name);
    }

    @Override
    public void save(SubjectEntity subject) {
        subjectRepository.save(subject);
    }
}
