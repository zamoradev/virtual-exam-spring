package com.springboot.virtualexam.student_exam_response.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.springboot.virtualexam.response.data.ResponseEntity;
import com.springboot.virtualexam.student_exam.data.StudentExamEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "estudiante_examen_repuesta")
@NoArgsConstructor
@AllArgsConstructor
public class StudentExamResponseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "puntaje", nullable = false)
    private double score;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "repuesta_id")
    private ResponseEntity response;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estudiante_examen_id")
    private StudentExamEntity studentExam;

    private static final long serialVersionUID = 1L;
}
