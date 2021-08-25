package com.springboot.virtualexam.section.service;

import com.springboot.virtualexam.section.data.SectionEntity;

public interface ISectionService {
    boolean existByName(char name);
    void save(SectionEntity section);
}
