package com.springboot.virtualexam.degree.service;

import com.springboot.virtualexam.degree.data.DegreeEntity;

public interface IDegreeService {
    boolean existByName(String name);
    void save(DegreeEntity degree);
}
