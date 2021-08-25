package com.springboot.virtualexam.degree.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IDegreeRepository extends JpaRepository<DegreeEntity, Long> {
    boolean existsDegreeByName(String name);
}
