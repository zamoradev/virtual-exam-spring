package com.springboot.virtualexam.student.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.springboot.virtualexam.degree.data.DegreeEntity;
import com.springboot.virtualexam.section.data.SectionEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "estudiante")
@NoArgsConstructor
@AllArgsConstructor
public class StudentEntity implements Serializable{

    @Id
    @Column(length = 6, unique = true, nullable = false)
    private String id;

    @Column(name = "nombre", length = 50, nullable = false)
    private String name;

    @Column(name = "apellido", length = 50, nullable = false)
    private String lastName;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate birthday;

    @Column(name = "foto", length = 150, nullable = false)
    private String photo;

    @Column(name = "celular", length = 9, nullable = false)
    private String cellphone;

    @Column(name = "direccion", length = 200, nullable = false)
    private String address;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grado_id")
    private DegreeEntity degree;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seccion_id")
    private SectionEntity section;

    private static final long serialVersionUID = 1L;
}
