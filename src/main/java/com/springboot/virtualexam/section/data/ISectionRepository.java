package com.springboot.virtualexam.section.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ISectionRepository extends JpaRepository<SectionEntity, Long> {
    boolean existsSectionByName(char name);
}
