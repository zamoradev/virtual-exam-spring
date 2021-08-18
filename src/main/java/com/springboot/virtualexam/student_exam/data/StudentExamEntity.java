package com.springboot.virtualexam.student_exam.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.springboot.virtualexam.exam.data.ExamEntity;
import com.springboot.virtualexam.student.data.StudentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "estudiante_examen")
@NoArgsConstructor
@AllArgsConstructor
public class StudentExamEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "activo", nullable = false)
    private boolean enabled;

    @Column(name = "calificacion", nullable = false)
    private double qualification;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "examen_id")
    private ExamEntity exam;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estudiante_id")
    private StudentEntity student;

    private static final long serialVersionUID = 1L;
}
