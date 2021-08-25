package com.springboot.virtualexam.section.service;

import com.springboot.virtualexam.section.data.ISectionRepository;
import com.springboot.virtualexam.section.data.SectionEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SectionServiceImpl implements ISectionService{
    private final ISectionRepository sectionRepository;

    @Override
    public boolean existByName(char name) {
        return sectionRepository.existsSectionByName(name);
    }

    @Override
    public void save(SectionEntity section) {
        sectionRepository.save(section);
    }
}
