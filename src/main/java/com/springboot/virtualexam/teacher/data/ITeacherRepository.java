package com.springboot.virtualexam.teacher.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ITeacherRepository extends JpaRepository<TeacherEntity, String> {
    boolean existsTeacherByDuiOrCellphoneOrEmail(String dui, String cellphone, String email);
}
