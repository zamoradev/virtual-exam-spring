package com.springboot.virtualexam.rol.service;

import com.springboot.virtualexam.rol.data.RolEntity;

public interface IRolService {
    RolEntity getByRolName(String name);
}
