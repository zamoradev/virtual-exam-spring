package com.springboot.virtualexam.degree.service;

import com.springboot.virtualexam.degree.data.DegreeEntity;
import com.springboot.virtualexam.degree.data.IDegreeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DegreeServiceImpl implements IDegreeService{
    private final IDegreeRepository degreeRepository;

    @Override
    public boolean existByName(String name) {
        return degreeRepository.existsDegreeByName(name);
    }

    @Override
    public void save(DegreeEntity degree) {
        degreeRepository.save(degree);
    }
}
