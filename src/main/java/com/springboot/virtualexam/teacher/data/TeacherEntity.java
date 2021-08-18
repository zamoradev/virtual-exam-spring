package com.springboot.virtualexam.teacher.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "docente")
@NoArgsConstructor
@AllArgsConstructor
public class TeacherEntity implements Serializable {

    @Id
    @Column(length = 6, unique = true, nullable = false)
    private String id;

    @Column(name = "nombre", length = 50, nullable = false)
    private String name;

    @Column(name = "apellido", length = 50, nullable = false)
    private String lastName;

    @Column(name = "dui", length = 10, nullable = false)
    private String dui;

    @Column(name = "celular", length = 9, nullable = false)
    private String cellphone;

    @Column(name = "direccion", length = 200, nullable = false)
    private String address;

    @Column(name = "correo_electronico", length = 75, nullable = false)
    private String email;

    @Column(name = "foto", length = 150, nullable = false)
    private String photo;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate birthday;

    private static final long serialVersionUID = 1L;
}
