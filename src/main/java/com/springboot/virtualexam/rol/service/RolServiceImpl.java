package com.springboot.virtualexam.rol.service;

import com.springboot.virtualexam.rol.data.IRolRepository;
import com.springboot.virtualexam.rol.data.RolEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RolServiceImpl implements IRolService {
    private final IRolRepository rolRepository;

    @Override
    public RolEntity getByRolName(String name) {
        return rolRepository.findByName(name);
    }
}
