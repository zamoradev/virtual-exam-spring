package com.springboot.virtualexam.student.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<StudentEntity, String> {
    boolean existsTeacherByCellphoneOrEmail(String cellphone, String email);
}
