package com.springboot.virtualexam.response.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IResponseRepository extends JpaRepository<ResponseEntity, Long> {
}
