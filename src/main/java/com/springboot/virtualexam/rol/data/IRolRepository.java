package com.springboot.virtualexam.rol.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IRolRepository extends JpaRepository<RolEntity, Long> {
    RolEntity findByName(String name);
}
